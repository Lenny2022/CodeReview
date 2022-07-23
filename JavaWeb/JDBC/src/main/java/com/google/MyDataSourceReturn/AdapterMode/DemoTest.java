package com.google.MyDataSourceReturn.AdapterMode;

import org.junit.Test;

/**
 * @author: lenny
 * @Date: 2022/7/2 11:40
 * @Description:
 */
public class DemoTest {
    @Test
    public void Test1() {
        InnerImpl inner = new InnerImpl();
        inner.method1();
        inner.method2();
    }

    @Test
    public void Test2() {
        InnerImpl2 inner = new InnerImpl2();
        inner.method1();
    }
}

