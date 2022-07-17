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

@WebServlet("/cookie")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送Cookie
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username", "程咬金");



        //(tomcat9之后支持中文)cookie存中文,需要设置编码格式
        //String value = "程咬金";
        //value = URLEncoder.encode(value, "utf-8");
        //Cookie cookie = new Cookie("username", value);

        //1.2 设置cookie存活时间,
        //cookie.setMaxAge(60 * 60 * 24 * 7);       // 7天,单位是 秒
        // 1天
        cookie.setMaxAge(60 * 60 * 24);



        //2.发送Cookie,添加到响应头中
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
