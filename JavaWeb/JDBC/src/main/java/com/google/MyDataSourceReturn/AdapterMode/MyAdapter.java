package com.google.MyDataSourceReturn.AdapterMode;

/**
 * @author: lenny
 * @Date: 2022/7/2 11:32
 * @Description: 加abstract关键字作用: 可以实现多个接口, 只需要实现一个方法即可
 */
public abstract class MyAdapter implements Inner {
    @Override
    public void method1() {
        //System.out.println("method()1...MyAdapter implements Inner");
    }

    @Override
    public void method2() {
        System.out.println("method()2");
    }

    @Override
    public void method3() {

    }

    @Override
    public void method4() {

    }

    @Override
    public void method5() {

    }
}
