package com.study.datasource.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.config.ClickHouseConfiguration
 * @date : 2024/4/29 16:18
 */
@Configuration
public class ClickHouseConfiguration {
    @Resource
    private ClickHouseDataSourceFactory clickHouseDataSourceFactory;

    /**
     * ClickHouse数据源配置
     *
     * @return
     */
    @Bean
    public JdbcTemplate clickHouseTemplate() {
        return new JdbcTemplate(clickHouseDataSourceFactory.getClickHouseDataSource());
    }
}
