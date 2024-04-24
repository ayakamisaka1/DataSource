package com.study.datasource.controller;

import com.study.datasource.entity.po.UserPO;
import com.study.datasource.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/v1/index")
    public String index(){
        List<UserPO> list = userService.list();
        return list.get(0).getChineseName();
    }
}
