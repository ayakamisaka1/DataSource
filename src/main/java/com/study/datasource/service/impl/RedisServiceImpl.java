package com.study.datasource.service.impl;

import com.study.datasource.Until.RedisReentrantLock;
import com.study.datasource.service.RedisService;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
 * @className : com.study.datasource.service.impl.RedisServiceImpl
 * @date : 2024/4/24 10:28
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Resource
    private RedisReentrantLock redisReentrantLock;

    @Override
    public void redisAdd() {
        boolean lock = redisReentrantLock.lock("lock", "向世杰", 100000L);
        if (lock) {
            redisTemplate.opsForValue().set("向世杰", "redis");
        }else{
            throw new RuntimeException("拿不到锁");
        }
    }
}
