package com.study.datasource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.datasource.entity.po.UserPO;
import com.study.datasource.mapper.UserMapper;
import com.study.datasource.service.UserService;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.service.impl.UserServiceImpl
 * @date : 2024/4/23 17:03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements UserService {
}
