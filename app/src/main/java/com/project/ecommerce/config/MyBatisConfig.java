package com.project.ecommerce.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.project.ecommerce.dao",
        "com.project.ecommerce.mbg.mapper"})
public class MyBatisConfig {
    // creates the mapper bean
}