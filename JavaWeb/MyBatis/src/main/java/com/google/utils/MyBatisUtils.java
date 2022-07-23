package com.google.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * 抽取MyBatis的工具类
 * @author: lenny
 * @Date: 2022/7/3 14:52
 * @Description:
 */
public class MyBatisUtils {
    /**
     * 1.私有化构造方法,不允许外部创建对象
     */
    private MyBatisUtils() {
    }

    //2,声明工厂类的静态对象
    private static SqlSessionFactory sqlSessionFactory;

    //3.静态代码块,读取配置文件,创建SqlSessionFactory对象并保存到静态变量中
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatisConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //提供静态方法,获取SqlSessionFactory对象
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession(true);
    }

}
