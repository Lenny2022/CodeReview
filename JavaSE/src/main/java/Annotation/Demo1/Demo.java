package Annotation.Demo1;

import java.lang.reflect.Method;

/**
 * 自定义注解@Test, 方法
 *
 * @author: lenny
 * @Date: 2022/6/25 22:51
 * @Description: 自定义注解@Test, 方法上有 @Test 就执行这个方法
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //先通过"反射"执行所有的方法,看看哪些执行了,哪些没有执行
        //1. 通过反射获取类对象
        Class<?> cls = Class.forName("Annotation.Demo1.UseTest");

        //3.1创建一个对象
        //Object o = cls.newInstance();
        Object o = cls.getDeclaredConstructor().newInstance();

        //2. 通过类对象获取所有的方法
        Method[] methodsList = cls.getDeclaredMethods();

        //3. 遍历所有的方法
        for (Method method : methodsList) {
            //判断方法上是否有@Test注解
            if (method.isAnnotationPresent(Test.class)) {
                //执行方法,传参是 "对象",先 创建一个对象,然后再调用方法 (3.1步骤)
                method.invoke(o);
            }
        }

    }
}
