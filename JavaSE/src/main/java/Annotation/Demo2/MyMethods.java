package Annotation.Demo2;

/**
 * @author: lenny
 * @Date: 2022/6/25 23:12
 * @Description:
 */
public class MyMethods {
    //创建10个方法

    @Lenny
    public void method1() {
        // 异常
        int a = 1 / 0;
        System.out.println("method1()方法");
    }

    @Lenny
    public void method2() {
        System.out.println("method2()方法");
    }

    public void method3() {
        System.out.println("method3()方法");
    }

    @Lenny
    public void method4() {
        System.out.println("method4()方法");
    }

    public void method5() {
        System.out.println("method5()方法");
    }

    public void method6() {
        System.out.println("method6()方法");
    }

    public void method7() {
        System.out.println("method7()方法");
    }

    @Lenny
    public void method8() {
        System.out.println("method8()方法");
    }

    public void method9() {
        System.out.println("method9()方法");
    }

    @Lenny
    public void method10() {
        //空指针异常
        int[] a = new int[10];
        a[11] = 1;
        System.out.println("method10()方法");
    }

}
