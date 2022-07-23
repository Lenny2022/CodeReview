package com.google.OpenSourceDatabaseConnectionPool.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * @author: lenny
 * @Date: 2022/7/2 23:01
 * @Description: Druid是一个基于Java的数据库连接池，它可以让你在高并发的情况下，提高数据库的连接效率。
 * 使用步骤:
 *  导入 jar 包。
 *  编写配置文件，配置数据库连接池。
 *  通过 Properties 集合加载配置文件。
 *  通过 Druid 连接池工厂类获取数据库连接池对象。
 *  获取数据库连接进行使用。
 *  注意：Druid 不会自动加载配置文件，需要我们手动加载，但是文件的名称可以自定义。**
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception{
        //1.通过类加载器获取配置文件的输入流
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");

        Properties properties = new Properties();
        properties.load(is);

        //2.druid创建数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //3.druid获取数据库连接
        Connection connection = dataSource.getConnection();

        //4.druid执行sql语句
        String sql = "select * from student";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //5.执行sql语句，并返回结果集
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("sid") + "\t" + resultSet.getString("name"));
        }

        //6.关闭资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

        //这种方式每次都要写很多重复代码,我们可以定义一个工具类，让我们可以调用这个工具类的方法，这样我们就可以不用再写重复的代码了。

    }
}
