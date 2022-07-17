package com.google.web.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * @author: lenny
 * @Date: 2022/6/28 16:44
 * @Description: Session的基本使用
 */



@WebServlet("/SessionDemo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取请求的用户名
        // localhost:8080/虚拟路径/SessionDemo1?username=steve
        String username = request.getParameter("username");

        //2. 获取HttpSession对象
        HttpSession session = request.getSession();

        //3.将用户名存入session中
        session.setAttribute("username", username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
