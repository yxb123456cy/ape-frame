package com.oszero.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.oszero.mapper")
public class MybatisPlusConfig {
}
