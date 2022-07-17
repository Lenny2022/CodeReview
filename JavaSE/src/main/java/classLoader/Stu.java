package classLoader;

/**
 * @author: lenny
 * @Date: 2022/6/21 02:22
 * @Description:
 */
public class Stu {

    // 6.执行main方法,类也会被加载
    public static void main(String[] args) {

    }

    public static int a = 10;

    // 静态代码块在类被加载的时候会执行
    static {
        System.out.println("静态代码块");
    }

    /**
     * 静态方法, 类名.方法调用
     */
    public static void show() {
        System.out.println("静态方法 show()");
    }
}
