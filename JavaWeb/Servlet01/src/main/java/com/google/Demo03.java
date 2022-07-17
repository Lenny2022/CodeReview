package com.google;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet的生命周期
 *
 * @author: lenny
 * @Date: 2022/6/26 20:52
 * @Description:
 */
//@WebServlet("/Demo03")
public class Demo03 extends HttpServlet {

    //Servlet的生命周期
    // Servlet的生命周期是从Servlet容器创建Servlet到销毁Servlet的过程。


    //init()方法：初始化Servlet
    // Servlet容器在创建Servlet时，会调用Servlet的init()方法，这个方法只会被调用一次。


    @Override
    public void init() {
        System.out.println("对象创建了,并且初始化成功");
    }

    /**
     * doGet和doPost 都是Servlet的生命周期当中服务的过程
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("收到客户端的请求");

    }

    //destroy()方法：销毁Servlet
    // Servlet容器在销毁Servlet时，会调用Servlet的destroy()方法，这个方法只会被调用一次。
    @Override
    public void destroy() {
        System.out.println("对象销毁了");
    }
}
