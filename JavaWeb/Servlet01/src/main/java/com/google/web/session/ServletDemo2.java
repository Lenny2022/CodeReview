package com.google.web.session; /**
 * @author: lenny
 * @Date: 2022/6/28 16:46
 * @Description:
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/SessionDemo2")
public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1. 获取Session对象
        HttpSession session = request.getSession();

        //2. 获取共享数据
        Object username = session.getAttribute("username");

        //3. 将数据响应给浏览器
        response.getWriter().write("username:" + username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
