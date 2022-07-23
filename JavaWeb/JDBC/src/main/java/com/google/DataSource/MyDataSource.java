package com.google.DataSource;

import com.google.MyDataSourceReturn.Demo3;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author: lenny
 * @Date: 2022/7/2 08:19
 * @Description:
 */
public class MyDataSource implements DataSource {

    //准备一个容器,存放所有的连接对象
    //Collections.synchronizedList 把ArrayList集合变成线程安全的List集合
    private static final List<Connection> POLL = Collections.synchronizedList(new ArrayList<>());


    //2.定义静态代码块, 获取多个连接对象到容器当中去
    static {
        for (int i = 0; i < 10; i++) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
                POLL.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //3. 重写 getConnection方法,用于返回一个连接对象
    @Override
    public Connection getConnection() throws SQLException {
        //拿: 判断容器中是否有连接对象 如果有,则返回一个连接对象
        if (POLL.size() > 0) {
            //返回0号索引位置的连接对象
            Connection connection = POLL.remove(0);

            // 通过自定义的连接对象进行包装,
            Demo3 myConnection = new Demo3(connection, POLL);

            return myConnection;
        } else {
            //如果没有,则抛出运行时异常(JVM),程序直接终止
            throw new RuntimeException("没有可用的连接对象");
        }
    }

    //4. 提供一个获取连接池大小的方法
    public int getPoolSize() {
        return POLL.size();
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }



    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
