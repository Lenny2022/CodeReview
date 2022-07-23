package com.google.DataSource;

import com.google.MyDataSourceReturn.Demo4;
import org.junit.Test;

import java.sql.*;

/**
 * @author: lenny
 * @Date: 2022/7/2 09:04
 * @Description:
 */
public class MyDataSourceTest {
    @Test
    public void test1() throws SQLException {
        //1. 创建数据库连接池对象
        //MyDataSource myDataSource = new MyDataSource();

        //1.1 通过反射
        Demo4 myDataSource = new Demo4();

        //获取使用前的连接数
        System.out.println("使用前的连接数:" + myDataSource.getPoolSize());

        //2. 通过数据库连接池对象获取连接对象

        /*
         1."继承"方式不行, 因为继承的是JDBC4Connection类,没法使用定义的"继承 Demo1"类,


         */
        Connection connection = myDataSource.getConnection();
        System.out.println("通过数据库连接池对象获取连接对象: " + connection.getClass());

        //3. 查询Student表的数据
        String sql = "select * from student";
        /*
         *https://blog.csdn.net/u011161786/article/details/48394751?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-48394751-blog-108511560.pc_relevant_multi_platform_whitelistv2&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-48394751-blog-108511560.pc_relevant_multi_platform_whitelistv2&utm_relevant_index=1
         * 浅谈 JDBC 中 CreateStatement 和 PrepareStatement 的区别与优劣。
         *
         */
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        //4.处理结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("sid") + "," + resultSet.getString("NAME") + "," + resultSet.getInt("age") + "," + resultSet.getDate("birthday"));
        }

        //5.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

        //获取使用后的连接数
        System.out.println("使用后的连接数:" + myDataSource.getPoolSize());

    }

    //public void Test2() throws SQLException {
    //    //1. 创建数据库连接池对象
    //    MyDataSource myDataSource = new MyDataSource();
    //
    //    //获取使用前的连接数
    //    System.out.println("使用前的连接数:" + myDataSource.getPoolSize());
    //
    //    //2. 通过数据库连接池对象获取连接对象
    //    Connection connection = myDataSource.getConnection();
    //    System.out.println("通过数据库连接池对象获取连接对象: " + connection.getClass());
    //
    //    //3. 查询Student表的数据
    //    String sql = "select * from student where sid = '2'";
    //    /*
    //     *https://blog.csdn.net/u011161786/article/details/48394751?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-48394751-blog-108511560.pc_relevant_multi_platform_whitelistv2&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-48394751-blog-108511560.pc_relevant_multi_platform_whitelistv2&utm_relevant_index=1
    //     * 浅谈 JDBC 中 CreateStatement 和 PrepareStatement 的区别与优劣。
    //     *
    //     */
    //    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    //    ResultSet resultSet = preparedStatement.executeQuery();
    //
    //    //4.处理结果集
    //    while (resultSet.next()) {
    //        System.out.println(resultSet.getInt("sid") + "," + resultSet.getString("NAME") + "," + resultSet.getInt("age") + "," + resultSet.getDate("birthday"));
    //    }
    //
    //    //5.释放资源
    //    resultSet.close();
    //    preparedStatement.close();
    //    connection.close();
    //
    //    //获取使用后的连接数
    //    System.out.println("使用后的连接数:" + myDataSource.getPoolSize());
    //
    //}
    //@Test
}
