package classLoader;

/**
 * 类加载的时机( 6个)
 *
 * @author: lenny
 * @Date: 2022/6/21 02:27
 * @Description:
 */
public class Demo1 {
    public static void main(String[] args) {
        //1. 创建类的实例（对象）
        //Stu stu = new Stu();

        //2. 调用类的类方法 (静态方法)
        //Stu.show();

        //3. 调类的静态方法
        //Stu.a = 20;


        //4. 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象


        //5. 初始化某个类的子类
        // 创建子类对象会默认调用父类方法
        primaryStu primaryStu = new primaryStu();

        //6. 直接使用java.exe命令来运行某个主类
        //psvm 执行main方法， 类也会被加载
    }
}
