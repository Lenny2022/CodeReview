package com.google.utils;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: lenny
 * @Date: 2022/7/2 07:04
 * @Description:
 */
public class JDBCUtils {

    //1.私有构造方法,不让外部创建对象
    private JDBCUtils() {
    }

    //2.定义一个静态的成员变量
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    private static Connection connection;

    //2.静态代码块,在类加载的时候执行,且只执行一次
    static {
        //1.通过类加载器返回配置文件的字节输入流
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");

        //2.创建Properties对象,加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(is);

            //获取配置文件中的值,为变量赋值
            driverClass = properties.getProperty("driverClass");
            url = properties.getProperty("url");
            username = properties.getProperty("username");
            password = properties.getProperty("password");

            //3.注册驱动
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3.获取连接对象的方法
    public static Connection getConnection() {
        try {
            connection = (Connection) DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //4.释放连接对象的方法,分为两种情况:1.有结果集, 2.没有结果集
    public static void release(Connection connection, Statement statement, ResultSet resultSet) {
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

    // 4.1 方法的重载,用于释放连接对象的方法,分为两种情况:1.有结果集, 2.没有结果集
    public static void release(Connection connection, Statement statement) {
        release(connection, statement, null);
    }

}
