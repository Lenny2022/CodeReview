package classLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 类加载器加载某一资源文件
 *
 * @author: lenny
 * @Date: 2022/6/21 03:48
 * @Description:
 */
public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {
        // 1,获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        // 2,加载某一资源文件
        //getResourceAsStream : Returns an input stream for reading the specified resource.
        InputStream is = systemClassLoader.getResourceAsStream("temp.properties");

        Properties properties = new Properties();

        properties.load(is);

        System.out.println(properties);

        // 闭流
        // assert java断言 ,失败抛出 AssertionError
        assert is != null;
        is.close();
    }
}
