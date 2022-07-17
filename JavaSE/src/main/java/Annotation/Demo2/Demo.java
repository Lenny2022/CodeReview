package Annotation.Demo2;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author: lenny
 * @Date: 2022/6/25 23:17
 * @Description:
 */
public class Demo {

    //使用sl4j日志框架
    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);


    public static void main(String[] args) throws Exception {
        /*
        功能:
            1. 运行加了@Lenny注解的方法
            2. 没有异常,正常执行
            3. 有异常,抛出异常,打印异常信息
         */


        LOGGER.info("测试是否乱码");
        //1. 通过反射获取类对象
        Class<?> cls = Class.forName("Annotation.Demo2.MyMethods");

        //2. 通过类对象获取所有的方法
        Method[] methodsList = cls.getDeclaredMethods();

        //3.1 创建一个对象
        Object o = cls.getDeclaredConstructor().newInstance();

        //3. 遍历所有的方法
        for (Method method : methodsList) {

            //判断方法上是否有@Lenny注解
            if (method.isAnnotationPresent(Lenny.class)) {

                //执行方法,传参是 "对象",先 创建一个对象,然后再调用方法 (3.1步骤)
                try {
                    method.invoke(o);
                    System.out.println(method.getName() + ": 该方法没有异常");
                } catch (Exception e) {
                    //打印异常信息
                    //e.printStackTrace();
                    LOGGER.info(method.getName() + "这个方法有异常,异常信息为...: " + e.getCause().toString());
                }
            }
        }

    }
}
