package com.google.OpenSourceDatabaseConnectionPool;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 工具类,减少重复代码
 *
 * @author: lenny
 * @Date: 2022/7/3 00:02
 * @Description:
 */
public class DataSourceUtils {

    /**
     * 1.私有化构造方法,不允许外部创建对象
     */
    private DataSourceUtils() {
    }

    /**
     * 2.声明数据源变量
     */
    private static DataSource dataSource;


    //3.静态代码块,完成配置的初始化和获取数据库连接池对象
    static {
        //1.配置文件的加载
        InputStream is = DataSourceUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);

            //2.获取数据库连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 4.提供一个获取数据库连接的方法
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 5.供一个获取数据库连接池对象的方法
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 6.关闭资源
     */
    public static void closeResource(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //方法重载,关闭资源
    public static void closeResource(Connection connection, Statement statement) {
        closeResource(connection, statement, null);
    }

}

