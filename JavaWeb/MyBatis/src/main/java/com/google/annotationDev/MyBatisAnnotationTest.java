package com.google.annotationDev;

import com.google.annotationDev.mapper.StuMapper;
import com.google.bean.Student;
import com.google.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * ע�⿪��������
 *
 * @author: lenny
 * @Date: 2022/7/3 17:02
 * @Description:
 */
public class MyBatisAnnotationTest {
    /**
     * ��
     */
    @Test
    public void selectStu() {
        //1.ͨ��Utils�������ȡSqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.ͨ��sqlSession��ȡMapper�ӿڵ�ʵ�������
        /*
        �ӿڴ���ķ�ʽ,mybatis��̬���ɵĴ������, �൱�� new StudentMapperImpl(),�ײ��õ����Ƿ��似��
        �Ǻ�JDBC "�黹���ݿ����ӳ�"�е�"��̬����"��ʽһ��,���õ��� Proxy ��� newProxyInstance() ����,
        ��JDK��̬����,
        Proxy.newProxyInstance(), �����ֱ�Ϊ ClassLoader, ʵ���� InvocationHandler �ӿڵ�����,
            ��һ�����飬�����д�ŵ��Ǹ�����ʵ�ֵ����нӿ�, ���û��ָ������Ĭ��Ϊ��������ʵ�ֵ����нӿ�, ���ָ���ˣ���ֻʵ��ָ���Ľӿ�,
            InvocationHandler(���ô�����) �ӿڵ� invoke ��������ʵ�ֵķ��������е� Object proxy, Method method, Object[] args �ֱ�����˴�����󣬱�����ķ����������Ĳ���
            Proxy.newProxyInstance()����: ����һ��������󣬲���ʵ��ָ���Ľӿ�

            https://blog.csdn.net/luzhensmart/article/details/82914239 ��̬����
         */

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.���ýӿڵķ���,��ȡ���
        List<Student> students = mapper.selectAll();

        //������ӡ
        for (Student student : students) {
            System.out.println(student);
        }

        //4.�ͷ���Դ
        sqlSession.close();
    }

    /**
     * ����
     */
    @Test
    public void insertStu() {
        //1.ͨ��Utils�������ȡSqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.ͨ��sqlSession��ȡMapper�ӿڵ�ʵ�������
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.���ýӿڵķ���,��ȡ���
        Student student = new Student(null,"���첩ʿ4",42);
        mapper.insert(student);

        //4.�ͷ���Դ
        sqlSession.close();
    }

    /**
     * ��������
     */
    @Test
    public void batchInsertStu() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        for (int i = 0; i < 30; i++) {
            //10��90�������,
            int random = new Random().nextInt(81) + 10;
            Student stu = new Student(null, "���첩ʿ" + i, random);
            mapper.insert(stu);
        }
    }


    /**
     * �޸�
     */
    @Test
    public void updateStu() {
        //1.ͨ��Utils�������ȡSqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.ͨ��sqlSession��ȡMapper�ӿڵ�ʵ�������
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.���ýӿڵķ���,��ȡ���
        Student student = new Student(8,"���첩ʿ2",47);
        mapper.update(student);

        //4.�ͷ���Դ
        sqlSession.close();
    }

    /**
     * ɾ��
     */
    @Test
    public void deleteStu() {
        //1.ͨ��Utils�������ȡSqlSession����
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.ͨ��sqlSession��ȡMapper�ӿڵ�ʵ�������
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.���ýӿڵķ���,��ȡ���
        mapper.delete(8);

        //4.�ͷ���Դ
        sqlSession.close();
    }

    /**
     * ͨ��id����name��ѯ
     */
    @Test
    public void selectByIdOrName() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        List<Student> list = mapper.selectByIdOrName(9, "����");

        list.forEach(System.out::println);

        sqlSession.close();
    }
}
