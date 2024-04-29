package com.study.datasource.controller;

import com.study.datasource.entity.po.UserPO;
import com.study.datasource.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.controller.UserController
 * @date : 2024/4/23 17:04
 */
@RestController
@Tag(name = "用户接口")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    @Qualifier(value = "clickHouseTemplate")//指定使用clickhouse
    private JdbcTemplate clickHouseTemplate;


    @GetMapping("/v1/index")
    public String index(){
        List<UserPO> list = userService.list();
        int queryTimeout = clickHouseTemplate.getQueryTimeout();
        return list.get(0).getChineseName()+"哈哈我是ck："+queryTimeout;
    }
}
