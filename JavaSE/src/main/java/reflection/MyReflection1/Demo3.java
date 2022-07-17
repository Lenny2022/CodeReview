package reflection.MyReflection1;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 案例
 *
 * @author: lenny
 * @Date: 2022/6/23 08:36
 * @Description: 需求：写一个“框架类”，不能改变任意代码的情况下,可以帮助我们创建新的对象, 并执行其中的任意方法
 * 实现:
 * 1.配置文件
 * 2.反射
 */
public class Demo3 {
    public static void main(String[] args) throws Exception {

        /*
        Student student = new Student();
        student.study();

        Worker worker = new Worker();
        worker.work();

        上面这种方式不可以的, 我们需要使用反射来实现
        1.配置文件
        2.反射

        步骤:
            1.需要将创建的对象的全类名和需要执行的方法名写入配置文件中
            2,加载读取配置文件  --->  (以后只需要修改配置文件即可)
            3,使用反射来加载文件进内存
            4,创建对象
            5,执行方法
         */

        //1 创建properties对象
        Properties p = new Properties();

        //1.1 加载配置文件
        //1.1.1 获取类加载器
        ClassLoader classLoader = Demo3.class.getClassLoader();
        //1.1.2 获取文件输入流
        InputStream resourceAsStream = classLoader.getResourceAsStream("demo3.properties");

        //1.1.3 加载文件
        p.load(resourceAsStream);

        //1.2 获取配置文件中的值
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");

        // 打印的是全类名
        System.out.println(className);
        System.out.println(methodName);

        //2 创建对象
        Class<?> clazz = Class.forName(className);


         //Object o = clazz.newInstance();     //过时了
        Object o = clazz.getDeclaredConstructor().newInstance();


        // //3 获取方法对象
        Method method = clazz.getDeclaredMethod(methodName);

        // 禁用安全检查, 这个 私有的sleep() 方法就可以被执行了
        method.setAccessible(true);

        //4 执行方法
        method.invoke(o);
    }
}
