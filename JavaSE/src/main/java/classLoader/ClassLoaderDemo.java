package classLoader;

/**
 * 类加载器, 双亲委托机制
 *
 * @author: lenny
 * @Date: 2022/6/21 03:23
 * @Description:
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        /*
            自下而上:
            顶层: Bootstrap 引导类加载器
                  Extension 扩展类加载器
                  Application 系统类加载器

        • 工作原理
            （1）如果一个类加载器接收到了类加载的请求，它自己不会先去加载，会把这个请求委托给父类加载器去执行。
            （2）如果父类还存在父类加载器，则继续向上委托，一直委托到启动类加载器：Bootstrap ClassLoader
            （3）如果父类加载器可以完成加载任务，就返回成功结果，如果父类加载失败，就由子类自己去尝试加载，如果子类加载失败就会抛出ClassNotFoundException异常，这就是双亲委派模式
         */

        // 1.获取系统类加载器   ClassLoaders$AppClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        // 2.系统类加载器 父加载器  --->  ExtClassLoader 扩展类加载器
        // ClassLoaders$PlatformClassLoader  JDk9之后叫平台类加载器
        ClassLoader classLoader1 = systemClassLoader.getParent();
        System.out.println(classLoader1);

        // 3.引导类加载器  底层是C语言写的, Java无法读取
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

    }
}
