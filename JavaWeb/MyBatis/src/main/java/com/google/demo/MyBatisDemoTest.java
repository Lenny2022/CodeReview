package com.google.demo;

import com.google.bean.Student;
import com.google.utils.MyBatisUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author: lenny
 * @Date: 2022/7/3 01:13
 * @Description:
 */
public class MyBatisDemoTest {
    @Test
    public void test1() throws IOException {
        /*
        mybatis步骤:
        1.导入mybatis的jar包
        2.配置mybatis的全局配置文件(全局配置文件可以在类路径下的resources目录下找到)
        3.加载sql映射文件(sql映射文件可以在类路径下的resources目录下找到)
        4.获取sqlSessionFactory对象(sqlSessionFactory对象是mybatis框架的核心)
        5.获取sqlSession对象(sqlSession对象是mybatis框架的核心)
        6.获取接口的实现类对象(接口的实现类对象是mybatis框架的核心)
        7.执行sql语句

         */

        //1.加载核心配置文件(全局配置文件可以在类路径下的resources目录下找到)
        InputStream is = Resources.getResourceAsStream("MyBatisConfig_bak.xml");

        //2.获取sqlSessionFactory对象(sqlSessionFactory对象是mybatis框架的核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.获取sqlSession对象(sqlSession对象是mybatis框架的核心)
        //openSession() 获取sqlSession构建者对象, 空参的话, 默认是不自动提交事物的,参数为true,则自动提交事物
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.执行配置文件中的sql语句,并返回结果集
        //List<Student> stuList = sqlSession.selectList("StudentMapper.selectAll");

        /*for (Student student : stuList) {
            System.out.println(student);
        }*/

        // 配置文件里面的 namespace属性值是接口的全限定名, id属性值是接口的方法名  namespace.id
        Map<String, Student> stuMap = sqlSession.selectMap("StudentMapper.selectAll", "name");

        //1.第一种遍历方式
        stuMap.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        //2.第二种遍历方式
        //for (Map.Entry<Integer, Student> entry : stuMap.entrySet()) {
        //    System.out.println(entry.getKey() + ":" + entry.getValue());
        //}

        //3.第三种遍历方式
        //for (Integer key : stuMap.keySet()) {
        //    System.out.println(key + ":" + stuMap.get(key));
        //}
        //
        ////4.第四种遍历方式
        //for (Student value : stuMap.values()) {
        //    System.out.println(value);
        //}
        //

        //5.关闭资源
        sqlSession.close();
        is.close();

    }

    /**
     * 根据name查询
     */
    @Test
    public void selectByName() throws IOException {
        //1.加载核心配置文件(全局配置文件可以在类路径下的resources目录下找到)
        InputStream is = Resources.getResourceAsStream("MyBatisConfig_bak.xml");

        //2.获取sqlSessionFactory对象(sqlSessionFactory对象是mybatis框架的核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.获取sqlSession对象(sqlSession对象是mybatis框架的核心)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.执行并返回结果集
        Student stu = sqlSession.selectOne("StudentMapper.selectByName", "王五");
        System.out.println(stu);

        //5.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 新增学生
     */
    @Test
    public void insertStudent() throws IOException {
        //1.加载核心配置文件(全局配置文件可以在类路径下的resources目录下找到)
        InputStream is = Resources.getResourceAsStream("MyBatisConfig_bak.xml");

        //2.获取sqlSessionFactory对象(sqlSessionFactory对象是mybatis框架的核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.获取sqlSession对象(sqlSession对象是mybatis框架的核心)
        //空参, 不开启事务,默认不自动提交事物,可以看到执行后数据库没有变化
        //可以调用sqlSession.commit() 或者 sqlSession.rollback() 来提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //参数为true, 则自动提交事物
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //4.执行并返回结果集
        Student stu = new Student(null, "卡迪拉客", 17);  //id自增,不需要赋值

        //解决删除后,新增id不连续的问题
        // alter table student auto_increment = 1;

        sqlSession.insert("StudentMapper.insertStu", stu);

        //参数为空,手动提交事务,增删改的操作都需要手动提交事务
        //sqlSession.commit();

        //5.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 删除学生
     */
    @Test
    public void deleteById() throws IOException {
        //1.加载核心配置文件(全局配置文件可以在类路径下的resources目录下找到)
        InputStream is = Resources.getResourceAsStream("MyBatisConfig_bak.xml");

        //2.获取sqlSessionFactory对象(sqlSessionFactory对象是mybatis框架的核心)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.获取sqlSession对象(sqlSession对象是mybatis框架的核心)
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        int id = 6;

        //4.执行并返回结果集
        int delete = sqlSession.delete("StudentMapper.deleteById", id);

        if (delete > 0) {
            System.out.println("学生id为" + id + "的删除成功");
        } else {
            System.out.println("学生id为" + id + "的删除失败");
        }

        //5.关闭资源
        sqlSession.close();
        is.close();
    }

    /**
     * 测试工具类
     */
    @Test
    public void myBatisUtilsTest() {
        {
            //1.获取sqlSession对象
            SqlSession sqlSession = MyBatisUtils.getSqlSession();

            //4.执行并返回结果集
            Student stu = new Student(null, "homelander", 18);  //id自增,不需要赋值

            //解决删除后,新增id不连续的问题
            // alter table student auto_increment = 1;

            sqlSession.insert("StudentMapper.insertStu", stu);

            //5.关闭资源
            sqlSession.close();

        }
    }
}
