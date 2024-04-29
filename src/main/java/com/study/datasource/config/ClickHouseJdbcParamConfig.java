package com.study.datasource.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
 * @className : com.study.datasource.config.ClickHouseJdbcParamConfig
 * @date : 2024/4/29 15:57
 */
@Component
@Data
public class ClickHouseJdbcParamConfig {
    //@Value("${clickhouse.datasource.hikari.connection-timeout:60000}")
    private volatile long connectionTimeout=60000L;

    //@Value("${clickhouse.datasource.hikari.idle-timeout:600000}")
    private volatile long idleTimeout=600000L;

   // @Value("${clickhouse.datasource.hikari.max-lifetime:1800000}")
    private volatile long maxLifetime=1800000L;

    //@Value("${clickhouse.datasource.hikari.maximum-pool-size:12}")
    private volatile int maxPoolSize=12;

    private volatile int minIdle=4;

}
