package com.google.jdbcConfig;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author: lenny
 * @Date: 2022/7/27 08:40
 * @Description:
 */


public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_06_annotation");

        return dataSource;
    }
}
