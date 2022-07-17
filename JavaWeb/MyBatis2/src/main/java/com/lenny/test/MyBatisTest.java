package com.lenny.test;

import com.lenny.bean.Card;
import com.lenny.bean.Classes;
import com.lenny.bean.Student;
import com.lenny.table01.OneToOneMapper;
import com.lenny.table02.OneToManyMapper;
import com.lenny.table03.ManyToManyMapper;
import com.lenny.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author: lenny
 * @Date: 2022/7/15 21:07
 * @Description:
 */
public class MyBatisTest {

    /**
     * 多表查询 1对1
     */
    @Test
    public void selectAll() throws Exception{
        // 1,加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlFactory 工厂类对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂类对象获取SqlSession对象
        // true:代表自动提交事务,false:代表手动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.获取接口的实现类对象
        OneToOneMapper mapper = sqlSession.getMapper(OneToOneMapper.class);

        List<Card> cards = mapper.selectAll();

        //提交事务
        sqlSession.commit();

        // lambda表达式, 循环打印
        //cards.forEach(a -> System.out.println(a));
        cards.forEach(System.out::println);

        //5.关闭资源
        sqlSession.close();
        is.close();

    }

    /**
     * 多表查询 1对多
     */
    @Test
    public void selectAll2() throws Exception{
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        OneToManyMapper mapper = sqlSession.getMapper(OneToManyMapper.class);

        List<Classes> classes = mapper.selectAll();

        classes.forEach(System.out::println);

        sqlSession.close();
    }

    /**
     * 多表查询 多对多
     */
    @Test
    public void selectAll3() throws Exception{
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        ManyToManyMapper mapper = sqlSession.getMapper(ManyToManyMapper.class);

        List<Student> classes = mapper.selectAll();



        classes.forEach(System.out::println);

        sqlSession.close();
    }
}
