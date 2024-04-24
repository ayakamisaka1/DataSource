package com.study.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {
        "com.study.datasource.mapper"
})
public class DataSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataSourceApplication.class, args);
    }

}
