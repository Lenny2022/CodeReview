package com.google;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * ServletConfig常用方法
 *
 * @author: lenny
 * @Date: 2022/6/26 21:26
 * @Description:
 */
public class ServletConfigDemo extends HttpServlet  {

    private ServletConfig config;


    //2. 通过init()方法初始化ServletConfig对象
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("ServletConfigDemo 初始化成功");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletConfig常用方法
        //1. getInitParameter(String name)：获取ServletConfig对象中的指定参数值
        String encoding = config.getInitParameter("encoding");
        System.out.println("encoding:" + encoding);

        //2. getInitParameterNames()：获取ServletConfig对象中的所有参数名称
        Enumeration<String> parameterNames = config.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            System.out.println("parameterNames:" + nextElement);
        }

        //3. getServletName()：获取ServletConfig对象中的Servlet名称
        String servletName = config.getServletName();
        System.out.println("servletName:" + servletName);

        //4. getServletContext()：获取ServletConfig对象中的ServletContext对象
        //域对象, 核心是实现数据共享
        ServletContext servletContext = config.getServletContext();
        System.out.println("servletContext:" + servletContext);

    }
}
