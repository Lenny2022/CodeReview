package com.lenny.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: lenny
 * @Date: 2022/7/15 21:55
 * @Description: mybatis工具类
 */
public class MyBatisUtils {

    /**
     * log4j日志记录器, 代码即注释:
     * https://twitter.com/haoel/status/1547181058596151298?s=21&t=Vdz_yMcOucL6r_CupVviVQ
     * 原推文:绝大多数的程序注释都可以写成 log info 或是log debug以及 Unit Test，这样一来，代码质量和工程能力至少上一个新的台阶……
     */
    private static final Logger logger = Logger.getLogger(MyBatisUtils.class);

    /**
     * 提取出来私有,不允许外部创建对象
     */
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块的作用: 在类加载的时候执行,且只执行一次
    static {

        logger.info(" 静态代码块: 1,初始化mybatis的配置文件 2,创建SqlSessionFactory对象");

        try {
            InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() throws IOException {

        logger.info("静态方法，获取SqlSessionFactory对象, 加true开启自动提交事务");

        //SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSessionFactory.openSession(true);
    }
}
