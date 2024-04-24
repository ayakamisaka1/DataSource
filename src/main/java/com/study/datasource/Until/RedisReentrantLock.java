package com.study.datasource.Until;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.Until.RedisReentrantLock
 * @date : 2024/4/24 10:51
 */
@Component
public class RedisReentrantLock {
    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public boolean lock(String lockKey, String requestId, long expireTimeInSeconds) {
        // 使用 SETNX 命令尝试获取锁
        Boolean lockAcquired = redisTemplate.opsForValue().setIfAbsent(lockKey, requestId);
        if (lockAcquired != null && lockAcquired) {
            // 获取锁成功，设置过期时间
            redisTemplate.expire(lockKey, expireTimeInSeconds, TimeUnit.SECONDS);
            return true;
        } else {
            // 锁已被其他客户端占用，检查是否为当前线程持有锁
            String currentValue = redisTemplate.opsForValue().get(lockKey);
            if (currentValue != null && currentValue.equals(requestId)) {
                // 是当前线程持有锁，重新获取锁并更新过期时间
                redisTemplate.opsForValue().set(lockKey, requestId, expireTimeInSeconds, TimeUnit.SECONDS);
                return true;
            }
            // 不是当前线程持有锁或者锁已经过期
            return false;
        }
    }

    public void unlock(String lockKey, String requestId) {
        String currentValue = redisTemplate.opsForValue().get(lockKey);
        if (currentValue != null && currentValue.equals(requestId)) {
            // 是当前线程持有锁，释放锁
            redisTemplate.delete(lockKey);
        }
    }
}
