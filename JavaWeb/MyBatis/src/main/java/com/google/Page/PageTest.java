package com.google.Page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.annotationDev.mapper.StuMapper;
import com.google.bean.Student;
import com.google.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * mybatis分页测试
 *
 * @author: lenny
 * @Date: 2022/7/3 19:06
 * @Description:
 */
public class PageTest {

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //分页处理
        //第一页,每页显示4条(正常逻辑)
        PageHelper.startPage(8, 5);

        List<Student> students = mapper.selectAll();

        students.forEach(System.out::println);

        //4.释放资源
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        PageHelper.startPage(2, 3);

        List<Student> studentsList = mapper.selectAll();

        //分页


        //分页插件相关参数
        PageInfo<Student> pageInfo = new PageInfo<>(studentsList);

        System.out.println("总条数: " + pageInfo.getTotal());
        System.out.println("总页数: " + pageInfo.getPages());
        System.out.println("当前页数: " + pageInfo.getPageNum());
        System.out.println("每页显示条数: " + pageInfo.getPageSize());
        System.out.println("是否有下一页: " + pageInfo.isHasNextPage());



        //4.释放资源
        sqlSession.close();
    }

}
