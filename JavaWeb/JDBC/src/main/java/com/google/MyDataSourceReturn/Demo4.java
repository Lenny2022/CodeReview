package com.google.MyDataSourceReturn;

import javax.sql.DataSource;
import javax.swing.plaf.basic.BasicComboPopup;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
 * @Date: 2022/7/2 20:52
 * @Description: 1, 定义一个类，实现 DataSource 接口
 * 2,定义一个容器，用于保存多个Connection连接对象
 * 3,定义静态代码块，通过 JDBC 工具类获取 10 个连接保存到容器中
 * 4,重写 getConnection 方法，从容器中获取一个连接
 * 5,通过 Proxy 代理，如果是 close 方法，就将连接归还池中。如果是其他方法则调用原有功能
 * 6,定义 getSize 方法，用于获取容器的大小并返回
 */
public class Demo4 implements DataSource {

    // 1.定义一个容器，用于保存多个Connection连接对象
    private static final List<Connection> POOL = Collections.synchronizedList(new ArrayList<>());

    // 2.定义静态代码块，通过 JDBC 工具类获取 10 个连接保存到容器中
    static {
        for (int i = 0; i < 10; i++) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "root");
                POOL.add(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 4.提供一个获取连接池大小的方法
    public int getPoolSize() {
        return POOL.size();
    }

    /**
     * 动态代理
     *
     * @return 代理对象
     */
    @Override
    public Connection getConnection() throws SQLException {
        if (POOL.size() > 0) {
            Connection connection = POOL.remove(0);
            /*
            Proxy.newProxyInstance(), 参数分别为 ClassLoader, 实现了 InvocationHandler 接口的类型,
            和一个数组，数组中存放的是该类型实现的所有接口, 如果没有指定，则默认为该类型所实现的所有接口, 如果指定了，则只实现指定的接口,
            InvocationHandler(调用处理器) 接口的 invoke 方法就是实现的方法，其中的 Object proxy, Method method, Object[] args 分别代表了代理对象，被代理的方法，方法的参数
            Proxy.newProxyInstance()作用: 创建一个代理对象，并且实现指定的接口

            https://blog.csdn.net/luzhensmart/article/details/82914239 动态代理
             */
            Connection connectionProxy = (Connection) Proxy.newProxyInstance(connection.getClass().getClassLoader(), new Class[]{Connection.class}, new InvocationHandler() {
                        /**
                         * 执行Connection实现类连接对象所有的方法都会经过invoke
                         * 如果是close方法，归还连接
                         * 如果不是，直接执行连接对象原有的功能即可
                         *
                         * @param proxy  代理对象
                         * @param method 被代理的方法
                         * @param args   方法的参数
                         * @return
                         * @throws Throwable
                         */
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            if ("close".equals(method.getName())) {
                                // 归还连接
                                POOL.add((Connection) proxy);
                                return null;
                            } else {
                                return method.invoke(connection, args);
                            }
                        }
                    }
            );
            // 返回代理对象的作用是：让调用者可以调用代理对象的方法，而不需要调用连接对象的方法
            return connectionProxy;
        } else {
            throw new RuntimeException("连接池中没有连接");
        }
    }

    /*
    Class[] cs = {MyInterface.class};
    MyInterface mi = (MyInterface)Proxy.newProxyInstance(loader, cs, h);
　　上面代码中，Proxy类的静态方法newProxyInstance()方法生成了一个对象，这个对象实现了cs数组中指定的接口。没错，返回值mi是MyInterface接口的实现类。你不要问这个类是哪个类，你只需要知道mi是MyInterface接口的实现类就可以了。你现在也不用去管loader和h这两个参数是什么东东，你只需要知道，Proxy类的静态方法newProxyInstance()方法返回的方法是实现了指定接口的实现类对象，甚至你都没有看见实现类的代码。
　　动态代理就是在运行时生成一个类，这个类会实现你指定的一组接口，而这个类没有.java文件，是在运行时生成的，你也不用去关心它是什么类型的，你只需要知道它实现了哪些接口即可。

3　newProxyInstance()方法的参数
　　Proxy类的newInstance()方法有三个参数：
　　　　ClassLoader loader：它是类加载器类型，你不用去理睬它，你只需要知道怎么可以获得它就可以了：MyInterface.class.getClassLoader()就可以获取到ClassLoader对象，没错，只要你有一个Class对象就可以获取到ClassLoader对象；
　　　　Class[] interfaces：指定newProxyInstance()方法返回的对象要实现哪些接口，没错，可以指定多个接口，例如上面例子只我们只指定了一个接口：Class[] cs = {MyInterface.class};
　　　　InvocationHandler h：它是最重要的一个参数！它是一个接口！它的名字叫调用处理器！你想一想，上面例子中mi对象是MyInterface接口的实现类对象，那么它一定是可以调用fun1()和fun2()方法了，难道你不想调用一下fun1()和fun2()方法么，它会执行些什么东东呢？其实无论你调用代理对象的什么方法，它都是在调用InvocationHandler的invoke()方法！
     */

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
