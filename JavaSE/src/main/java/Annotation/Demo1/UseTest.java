package Annotation.Demo1;


/**
 * @author: lenny
 * @Date: 2022/6/25 22:45
 * @Description:
 */
public class UseTest {
    //没有使用test注解
    public void show() {
        System.out.println("show()方法, 没有使用test注解");
    }

    //使用test注解
    @Test
    public void method() {
        System.out.println("method()方法, 使用test注解");
    }

    @Test
    public void function() {
        System.out.println("function()方法, 使用test注解");
    }



}
