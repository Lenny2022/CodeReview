package com.google.annotationDev;

import com.google.annotationDev.mapper.StuMapper;
import com.google.bean.Student;
import com.google.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Random;

/**
 * 注解开发测试类
 *
 * @author: lenny
 * @Date: 2022/7/3 17:02
 * @Description:
 */
public class MyBatisAnnotationTest {
    /**
     * 查
     */
    @Test
    public void selectStu() {
        //1.通过Utils工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.通过sqlSession获取Mapper接口的实现类对象
        /*
        接口代理的方式,mybatis动态生成的代理对象, 相当于 new StudentMapperImpl(),底层用到的是反射技术
        是和JDBC "归还数据库连接池"中的"动态代理"方式一样,都用到了 Proxy 类的 newProxyInstance() 方法,
        即JDK动态代理,
        Proxy.newProxyInstance(), 参数分别为 ClassLoader, 实现了 InvocationHandler 接口的类型,
            和一个数组，数组中存放的是该类型实现的所有接口, 如果没有指定，则默认为该类型所实现的所有接口, 如果指定了，则只实现指定的接口,
            InvocationHandler(调用处理器) 接口的 invoke 方法就是实现的方法，其中的 Object proxy, Method method, Object[] args 分别代表了代理对象，被代理的方法，方法的参数
            Proxy.newProxyInstance()作用: 创建一个代理对象，并且实现指定的接口

            https://blog.csdn.net/luzhensmart/article/details/82914239 动态代理
         */

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.调用接口的方法,获取结果
        List<Student> students = mapper.selectAll();

        //遍历打印
        for (Student student : students) {
            System.out.println(student);
        }

        //4.释放资源
        sqlSession.close();
    }

    /**
     * 新增
     */
    @Test
    public void insertStu() {
        //1.通过Utils工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.通过sqlSession获取Mapper接口的实现类对象
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.调用接口的方法,获取结果
        Student student = new Student(null,"奇异博士4",42);
        mapper.insert(student);

        //4.释放资源
        sqlSession.close();
    }

    /**
     * 批量新增
     */
    @Test
    public void batchInsertStu() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        for (int i = 0; i < 30; i++) {
            //10到90随机整数,
            int random = new Random().nextInt(81) + 10;
            Student stu = new Student(null, "奇异博士" + i, random);
            mapper.insert(stu);
        }
    }


    /**
     * 修改
     */
    @Test
    public void updateStu() {
        //1.通过Utils工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.通过sqlSession获取Mapper接口的实现类对象
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.调用接口的方法,获取结果
        Student student = new Student(8,"奇异博士2",47);
        mapper.update(student);

        //4.释放资源
        sqlSession.close();
    }

    /**
     * 删除
     */
    @Test
    public void deleteStu() {
        //1.通过Utils工具类获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //2.通过sqlSession获取Mapper接口的实现类对象
        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        //3.调用接口的方法,获取结果
        mapper.delete(8);

        //4.释放资源
        sqlSession.close();
    }

    /**
     * 通过id或者name查询
     */
    @Test
    public void selectByIdOrName() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StuMapper mapper = sqlSession.getMapper(StuMapper.class);

        List<Student> list = mapper.selectByIdOrName(9, "李四");

        list.forEach(System.out::println);

        sqlSession.close();
    }
}
