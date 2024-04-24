package com.study.datasource.controller;

import com.study.datasource.service.RedisService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.controller.RedisController
 * @date : 2024/4/24 10:28
 */
@RestController
@Tag(name = "redis接口")
public class RedisController {
    @Resource
    private RedisService redisService;
    @GetMapping("/v1/redis/add")
    public void redisAdd(){
        redisService.redisAdd();
    }
}
