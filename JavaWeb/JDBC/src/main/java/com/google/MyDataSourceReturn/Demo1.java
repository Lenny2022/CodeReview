package com.google.MyDataSourceReturn;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.JDBC4Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * "继承" 归还数据库连接的方法
 *
 * @author: lenny
 * @Date: 2022/7/2 09:52
 * @Description:
 */
public class Demo1 extends JDBC4Connection {
    /*
    "继承" 方式来归还数据库连接的思想, 发现DriverManager获取连接的实现类是 JDBC4Connection
    定义一个类去继承 JDBC4Connection类, 重写close()方法, 完成连接对象的归还

   实现步骤:
   1.定义一个类,去继承 JDBC4Connection类,重写close()方法
   2.定义Connection对象,调用JDBC4Connection类的方法,获取连接对象
   3.通过有参构造方法完成对成员变量的赋值
   4.重写close()方法,完成连接对象的归还

   不足:
   继承方式行不通, 因为继承的是JDBC4Connection类.

     */

    //2.定义Connection对象,调用JDBC4Connection类的方法,获取连接对象
    private final Connection connection;
    private final List<Connection> poll;

    //3.通过有参构造方法完成对成员变量的赋值( 添加这两个对象进去 )
    public Demo1(String hostToConnectTo, int portToConnectTo, Properties info, String databaseToConnectTo, String url, Connection connection, List<Connection> poll) throws SQLException {
        super(hostToConnectTo, portToConnectTo, info, databaseToConnectTo, url);
        this.connection = connection;
        this.poll = poll;
    }

    //4. 重写close()方法,完成连接对象的归还
    @Override
    public void close() throws SQLException {
        // 连接对象添加到连接池中,就是归还连接对象
        poll.add(connection);

        //不再调用父类的close()方法,直接调用父类的close()方法,完成连接对象的归还
        //super.close();
    }
}
