package com.lenny.MultiTableAnnotation;

import com.lenny.MultiTableAnnotation.many_many.StudentMapper;
import com.lenny.MultiTableAnnotation.one_many.ClassesMapper;
import com.lenny.MultiTableAnnotation.one_one.CardMapper;
import com.lenny.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 注解开发测试类
 *
 * @author: lenny
 * @Date: 2022/7/3 17:02
 * @Description:
 */
public class MyBatisAnnotationTest {

    @Test
    public void selectAll() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        sqlSession.getMapper(CardMapper.class).selectAll().forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void selectAll2() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        sqlSession.getMapper(ClassesMapper.class).selectAll().forEach(System.out::println);

        sqlSession.close();
    }

    @Test
    public void selectAll3() throws Exception {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        sqlSession.getMapper(StudentMapper.class).selectAll().forEach(System.out::println);

        sqlSession.close();
    }
}
