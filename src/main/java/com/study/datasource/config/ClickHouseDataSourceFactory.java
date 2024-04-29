package com.study.datasource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import ru.yandex.clickhouse.BalancedClickhouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import javax.sql.DataSource;

/**
 * <p>
 *
 * </p>
 *
 * @author : ayaka
 * @version : 1.0
 * @appName : DataSource
 * @moduleName : DataSource
 * @className : com.study.datasource.config.ClickHouseDataSourceFactory
 * @date : 2024/4/29 16:05
 */
@Component
public class ClickHouseDataSourceFactory {
    @Resource
    private ClickHouseJdbcParamConfig clickHouseHikariConfig;

    /**
     * clickhouse数据库连接地址，集群模式下使用逗号分隔
     */
    @Value("${spring.datasource.clickhouse.url}")
    private String url;

    /**
     * clickhouse数据库密码
     */
    @Value("${spring.datasource.clickhouse.password}")
    private String password;

    /**
     * clickhouse用户
     */
    @Value("${spring.datasource.clickhouse.username}")
    private String user;

    /**
     * 数据库实例名称
     */
    @Value("${spring.datasource.clickhouse.database}")
    private String database;

    /**
     * 时区
     */
    //@Value("${spring.datasource.clickhouse.useTimeZone}")
    private String useTimeZone="Asia/Shanghai";

    /**
     * 超时时间
     */
    private int socketTimeOut=20000;




    /**
     * 获取
     *
     * @return
     */
    public DataSource getClickHouseDataSource() {
        //
        ClickHouseProperties clickHouseProperties = new ClickHouseProperties();
        clickHouseProperties.setSocketTimeout(socketTimeOut);
        clickHouseProperties.setUseServerTimeZone(false);
        clickHouseProperties.setUseTimeZone(useTimeZone);
        if (!StringUtils.isEmpty(password) && !StringUtils.isEmpty(user)) {
            clickHouseProperties.setUser(user);
            clickHouseProperties.setPassword(password);
        }
        //
        String covertUrl = getCovertUrl();
        return convertToHikari(new BalancedClickhouseDataSource(covertUrl, clickHouseProperties));
    }

    /**
     * 获取处理过的clickhouse连接
     *
     * @return
     */
    private String getCovertUrl() {
        if (!url.startsWith("jdbc:clickhouse:")) {
            url = "jdbc:clickhouse://" + url + "/" + database;
        }
        return url;
    }

    /**
     * 转换为Hikari源
     *
     * @param dataSource
     * @return
     */
    private HikariDataSource convertToHikari(final DataSource dataSource) {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setConnectionTimeout(clickHouseHikariConfig.getConnectionTimeout());
        hikariConfig.setIdleTimeout(clickHouseHikariConfig.getIdleTimeout());
        hikariConfig.setMaximumPoolSize(clickHouseHikariConfig.getMaxPoolSize());
        hikariConfig.setMinimumIdle(clickHouseHikariConfig.getMinIdle());
        hikariConfig.setMaxLifetime(clickHouseHikariConfig.getMaxLifetime());
        hikariConfig.setDataSource(dataSource);
        //
        return new HikariDataSource(hikariConfig);
    }

}
