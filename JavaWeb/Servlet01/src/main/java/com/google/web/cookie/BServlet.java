package com.google.web.cookie; /**
 * @author: lenny
 * @Date: 2022/6/27 16:05
 * @Description:
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getCookie")
public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取所有的Cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            //获取指定的Cookie
            for (Cookie cookie : cookies) {
                //if ("name".equals(cookie.getName())) {
                    System.out.println("cookie.getName():" + cookie.getName());
                    System.out.println("cookie.getValue():" + cookie.getValue());
                //}
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
