package reflection.MyReflection1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射获取
 *
 * @author: lenny
 * @Date: 2022/6/22 08:41
 * @Description:
 */
public class Demo2 {
    public static void main(String[] args) throws Exception {
        //method1();
        //method2();
        method3();
        //method4();
    }

    /**
     * 反射获取成员方法
     * | Method[] getMethods()                                        | 返回所有公共成员方法对象的数组，包括继承的 |
     * | Method[] getDeclaredMethods()                                | 返回所有成员方法对象的数组，不包括继承的   |
     * | Method getMethod(String name, Class<?>... parameterTypes)    | 返回单个公共成员方法对象                   |
     * | Method getDeclaredMethod(String name, Class<?>... parameterTypes) | 返回单个成员方法对象             |
     */
    private static void method3() throws Exception {
        // 1. 获取Student类的Class对象
        Class<Student> studentClass = Student.class;

        // 2. 获取Student类的所有public公共成员方法对象的数组
        //Method[] methods = studentClass.getMethods();
        //System.out.println("开启暴力反射，获取Student类的所有public公共成员方法对象的数组");
        //int i = 0;
        //for (Method method : methods) {
        //    i++;
        //    //method.setAccessible(true);
        //    System.out.println(method);
        //    System.out.println(i + ":" + method.getName());
        //}

        //3. 获取指定空参单个public公共成员方法对象
        //Method studyMethod = studentClass.getMethod("study");
        Student stu = new Student();
        // invoke() 方法：调用对象的方法
        //studyMethod.invoke(stu);

        // 3.获取指定有参数的公共成员方法对象
        //Method studyMethod2 = studentClass.getMethod("study", String.class);
        //studyMethod2.invoke(stu, "Java");

        // 4. 获取指定单个private成员方法对象
        Method sleepMethod = studentClass.getDeclaredMethod("sleep");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //获取方法名
            System.out.println(declaredMethod.getName());
            // System.out.println(declaredMethod);
        }

        //sleepMethod.setAccessible(true);
        //sleepMethod.invoke(stu);

       // Method sleepMethod = studentClass.getDeclaredMethod("sleep");

        //setAccessible(true)：开启或者禁用安全检查，如果为true，则可以访问private方法，否则不能访问
        // sleepMethod.setAccessible(true);

        // System.out.println(sleepMethod);
        // sleepMethod.invoke(stu);

    }


    /**
     * 反射和获取成员变量, getFiled
     * 成员变量的操作:
     * 1, 获取
     * 2, 设置
     */
    private static void method1() throws Exception {
        //1.先获取class对象
        Class<?> c1 = Class.forName("reflection.MyReflection1.Worker");

        //2.获取成员变量
        Field f1 = c1.getField("salary");
        Worker w = new Worker();
        Object o = f1.get(w);
        System.out.println("1. 获取成员变量salary : " + o);

        //3.设置成员变量
        f1.set(w, 10086);
        System.out.println("2. 设置成员变量salary : " + w.salary);

        //4.获取所有public的成员变量
        Field[] fs = c1.getFields();
        for (Field f : fs) {
            System.out.println("3. 获取所有public的成员变量 : " + f.getName());
        }

        //5.获取所有成员变量
        Field[] fs1 = c1.getDeclaredFields();
        for (Field f : fs1) {
            System.out.println("4. 获取所有成员变量 : " + f.getName());
        }

        //6.获取指定public的成员变量
        Field f2 = c1.getField("num");
        System.out.println("5. 获取指定public的成员变量 : " + f2.getName());

        // 6.1 获取指定public的成员变量
        Field f21 = c1.getDeclaredField("name");
        // 暴力反射
        f21.setAccessible(true);
        System.out.println("6.1 暴力反射获取任意 权限修饰符的成员变量: " + f21.getName());

        //7.获取指定的成员变量
        Field f3 = c1.getDeclaredField("name");
        System.out.println("6. 获取指定的成员变量 : " + f3.getName());
    }

    /**
     * 1.获取构造方法
     * | Constructor<?>[] getConstructors()                           | 返回所有'公共'构造方法对象的数组 |
     * | ------------------------------------------------------------ | ------------------------------ |
     * | Constructor<?>[] getDeclaredConstructors()                   | 返回所有构造方法对象的数组     |
     * | Constructor<T> getConstructor(Class<?>... parameterTypes)    | 返回单个'公共'构造方法对象       |
     * | Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) | 返回单个构造方法对象      |
     * <p>
     * 2,利用反射创建对象
     */
    private static void method2() throws Exception {
        //1.先获取class对象
        Class<Teacher> teacherClass = Teacher.class;

        //2.获取单个public的构造方法   (构造方法只能根据参数类型来获取)
        Constructor<Teacher> constructor = teacherClass.getConstructor(String.class, int.class);
        System.out.println("1. 获取单个public的构造方法 : " + constructor.getName());

        //3.反射创建有参对象
        Object lenny = constructor.newInstance("lenny", 86);
        System.out.println("2. 反射创建有参对象 : " + lenny);

        //4.反射创建空参对象
        Constructor<Teacher> constructor1 = teacherClass.getConstructor();
        Object teacher = constructor1.newInstance();
        System.out.println("3. 反射创建无参对象 : " + teacher);

        // 4.1 反射创建空参对象,简化
        //Object teacher1 = teacherClass.newInstance();
        //System.out.println("4.1 反射创建无参对象(简化) : " + teacher1);

        // 代替过时的newInstance()
        Object teacher1 = teacherClass.getDeclaredConstructor().newInstance();
        System.out.println("4.1 反射创建无参对象(简化) : " + teacher1);

        //
    }

}
