package com.google.OpenSourceDatabaseConnectionPool;

import com.google.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: lenny
 * @Date: 2022/7/3 00:20
 * @Description:
 */
public class DruidUtilsDemo {
    public static void main(String[] args) throws SQLException {

        Student stu = new Student(6, "lenny", 27, new Date());

        Date d = stu.getBirthday();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = sdf.format(d);

        //sql
        String sql = "INSERT INTO student VALUES ('" + stu.getSid() + "','" + stu.getName() + "','" + stu.getAge() + "','" + birthday + "')";

        //1.通过工具类获取一个数据库连接池对象
        Connection connection = DataSourceUtils.getConnection();

        //2.获取执行者对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //3.执行sql语句，并返回结果集
        int resultSet = preparedStatement.executeUpdate(sql);


        System.out.println(resultSet);

        //4.关闭资源
        DataSourceUtils.closeResource(connection, preparedStatement, null);
    }
}
