package com.google;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 获取请求头信息
 *
 * @author: lenny
 * @Date: 2022/6/26 18:47
 * @Description:
 */
@WebServlet("/ServletDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.根据请求头名称获取一个值
        String connection = req.getHeader("connection");
        System.out.println("connection 请求头名称:" + connection);

        //2.根据请求头名称获取多个值
        Enumeration<String> acceptEncoding = req.getHeaders("Accept-Encoding");
        while (acceptEncoding.hasMoreElements()) {
            //类似于迭代器的next()方法
            String nextElement = acceptEncoding.nextElement();
            System.out.println("acceptEncoding 请求头名称:" + nextElement);
        }

        //3.获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String nextElement = headerNames.nextElement();
            System.out.println("headerNames 请求头名称:" + nextElement);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
