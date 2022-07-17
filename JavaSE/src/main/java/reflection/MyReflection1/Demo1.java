package reflection.MyReflection1;

/**
 * 获取class对象的三种方式:
 * @author: lenny
 * @Date: 2022/6/21 04:21
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
        获取class对象的三种方式:
            1.  Class.forName(全类名(包名+类名))方法
            2.  类名.class属性
            3.  对象名.getClass()方法

            分别代表了类加载的三个阶段
         */

        Class<?> c1 = Class.forName("reflection.MyReflection1.Student");
        System.out.println("1. Class.forName(全类名(包名+类名))方法: " + c1);

        Class<Student> c2 = Student.class;
        System.out.println("2. 类名.class属性 : " + c2);

        Student stu = new Student();
        Class<? extends Student> c3 = stu.getClass();
        System.out.println("3. 对象名.getClass()方法 : " + c3);

        System.out.println(c1.hashCode());

        System.out.println(c1 == c2);
        System.out.println(c1 == c3);

    }
}
