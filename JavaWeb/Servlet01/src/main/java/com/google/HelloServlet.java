package com.google;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

/**
 * 请求对象常用方法
 */
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取虚拟目录名称 getContextPath()
        String contextPath = request.getContextPath();
        System.out.println("contextPath 拟目录名称:" + contextPath);

        //2.获取Servlet映射路径 getServletPath()
        String servletPath = request.getServletPath();
        System.out.println("servletPath Servlet映射路径:" + servletPath);

        //3.获取访问者的ip getRemoteAddr()
        String remoteAddr = request.getRemoteAddr();
        System.out.println("remoteAddr 访问者的ip:" + remoteAddr);

        //4.获取请求消息的数据 getQueryString()
        String queryString = request.getQueryString();
        System.out.println("queryString 请求消息的数据:" + queryString);

        //5.获取统一资源标识符 getRequestURI()
        String requestURI = request.getRequestURI();
        System.out.println("requestURI 统一资源标识符:" + requestURI);

        //6.获取统一资源定位符 getRequestURL()
        String requestURL = request.getRequestURL().toString();
        System.out.println("requestURL 统一资源定位符:" + requestURL);
    }

    }