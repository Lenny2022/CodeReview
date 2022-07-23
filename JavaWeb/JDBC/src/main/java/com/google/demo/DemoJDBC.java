//package com.google.demo;
//
//import java.sql.*;
//
///**
// * @author: lenny
// * @Date: 2022/7/2 06:37
// * @Description:
// */
//public class DemoJDBC {
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//      /*  //1.注册驱动(通过反射的方式, 直接调用驱动类的静态代码块)
//        Class.forName("com.mysql.jdbc.Driver");
//
//        //2.获取连接
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
//
//        //3.获取执行者对象
//        Statement statement = connection.createStatement();
//
//        //4.执行sql语句,并返回结果集
//        String sql = "show create table user";
//        ResultSet resultSet = statement.executeQuery(sql);
//
//        //5.处理结果集
//        while (resultSet.next()) {
//            //System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
//            // 建表语句
//            System.out.println(resultSet.getString("Create Table"));
//        }
//
//        //6.关闭资源
//        //关闭结果集
//        resultSet.close();
//        //关闭statement对象
//        statement.close();
//        // 关闭连接
//        connection.close();*/
//    }
//}
//
//
//
