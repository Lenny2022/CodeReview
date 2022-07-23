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
 * mybatis��ҳ����
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

        //��ҳ����
        //��һҳ,ÿҳ��ʾ4��(�����߼�)
        PageHelper.startPage(8, 5);

        List<Student> students = mapper.selectAll();

        students.forEach(System.out::println);

        //4.�ͷ���Դ
        sqlSession.close();
    }

    @Test
    public void test2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        PageHelper.startPage(2, 3);

        List<Student> studentsList = mapper.selectAll();

        //��ҳ


        //��ҳ�����ز���
        PageInfo<Student> pageInfo = new PageInfo<>(studentsList);

        System.out.println("������: " + pageInfo.getTotal());
        System.out.println("��ҳ��: " + pageInfo.getPages());
        System.out.println("��ǰҳ��: " + pageInfo.getPageNum());
        System.out.println("ÿҳ��ʾ����: " + pageInfo.getPageSize());
        System.out.println("�Ƿ�����һҳ: " + pageInfo.isHasNextPage());



        //4.�ͷ���Դ
        sqlSession.close();
    }

}
