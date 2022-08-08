package com.google.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author: lenny
 * @Date: 2022/7/29 08:09
 * @Description:
 */
public class MyBatisConfig {

    @Bean
    // MyBatis就管理SqlSessionFactory对象
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 起别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.google.DO");

        sqlSessionFactoryBean.setDataSource(dataSource);

        // 事物处理先忽略
        return sqlSessionFactoryBean;
    }

    @Bean
    // MapperScannerConfigurer 是一个扫描器,扫描器可以扫描到指定的包下的所有的Mapper接口,并且将这些接口注册到IOC容器中
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.google.dao");
        return mapperScannerConfigurer;
    }

    // 开启Spring事物,得到了事物管理器,并且将事物管理器注册到IOC容器中
    @Bean
    // PlatformTransactionManager 是Spring提供的事物管理器,它是一个接口,
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        // 创建它的实现类,并return出去,这里用JDBC的事物管理器
       /* DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;*/

        // 和JdbcConfig中的 dataSource是同一个,这样才能使用事物统一管理
        return new DataSourceTransactionManager(dataSource);
    }

}

/*
    <?xml version="1.0" encoding="UTF-8" ?>
<!--MyBatis的DTD约束-->
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

<!--configuration 核心根标签-->
<configuration>

    <!--引入数据库连接的配置文件-->
    <properties resource="jdbc.properties"/>

    <!--配置LOG4J-->
    <settings>
        <setting name="logImpl" value="log4j"/>
    </settings>

    <!--起别名
        该方式将扫描该包下的所有类，默认为类名的小写。
    -->
    <typeAliases>
        <package name="com/lenny/bean"/>
    </typeAliases>

    <!--environments配置数据库环境，环境可以有多个。default属性指定使用的是哪个-->
    <environments default="mysql">
        <!--environment配置数据库环境  id属性唯一标识-->
        <environment id="mysql">
            <!-- transactionManager事务管理。  type属性，采用JDBC默认的事务-->
            <transactionManager type="JDBC"/>
            <!-- dataSource数据源信息   type属性 连接池-->
            <dataSource type="POOLED">
                <!-- property获取数据库连接的配置信息 -->
                <property name="driver" value="${driver}" />
                <property name="url" value="${url}" />
                <property name="username" value="${username}" />
                <property name="password" value="${password}" />
            </dataSource>
        </environment>
    </environments>

    <!-- mappers引入映射配置文件 -->
    <mappers>
        <!--<mapper resource = "com/lenny/MultiTable/one_one/OneToOneMapper.xml" />
        <mapper resource = "com/lenny/MultiTable/one_many/OneToManyMapper.xml" />
        <mapper resource = "com/lenny/MultiTable/many_many/ManyToManyMapper.xml" />-->
<!--        <mapper resource = "OneToOneMapper.xml" />-->
<!--        <mapper resource = "OneToManyMapper.xml" />-->
<!--        <mapper resource = "ManyToManyMapper.xml" />-->
        <!--注解开发-->
        <package name="com.lenny.MultiTableAnnotation.one_one"/>
        <package name="com.lenny.MultiTableAnnotation.one_many"/>
        <package name="com.lenny.MultiTableAnnotation.many_many"/>
    </mappers>
</configuration>
 */
