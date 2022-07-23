package com.google.MyDataSourceReturn;

import java.sql.Connection;
import java.util.List;

/**
 * "适配器" 归还数据库连接的方法
 * @author: lenny
 * @Date: 2022/7/2 11:00
 * @Description:
 */
public class Demo3 extends Adapter{
    /*
    适配器模式: 解决'接口'与'实现'之间的矛盾
    实现步骤:
    1.定义一个适配器类,实现Connection接口
    2.定义Connection连接对象的成员变量
    3.通过有参构造完成成员变量的赋值
    4.重写所有的Connection接口的方法(除了close方法),调用mysql驱动程序的方法
    5.定义一个连接类,继续适配器类,实现Connection接口
    6.定义Connection连接对象的成员变量,通过有参构造方法完成成员变量的赋值
    7.重写close方法,完成归还数据库连接的操作
    8.在自定义连接池类中,将获取的连接对象通过定义连接对象进行包装
     */


        //2.定义连接对象和连接池容器对象的成员变量
        private final Connection con;
        private final List<Connection> pool;

        //3.通过有参构造为变量赋值
        public Demo3(Connection con,List<Connection> pool) {
            super(con);
            this.con = con;
            this.pool = pool;
        }

        //4.重写close方法，完成归还连接
        @Override
        public void close() {
            pool.add(con);
        }
    }
