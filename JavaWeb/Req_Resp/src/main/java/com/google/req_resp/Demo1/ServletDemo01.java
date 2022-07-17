package com.google.req_resp.Demo1;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @author: lenny
 * @Date: 2022/6/26 20:07
 * @Description:
 */

@WebServlet("/ServletDemo01")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        // 把用户信息封装到一个对象当中
        //获取用户填写的信息 map集合
        Map<String, String[]> map = req.getParameterMap();

        //创建一个user对象
        User user = new User();

        // 利用beanutils工具类将map集合中的数据封装到user对象中
        try {
            BeanUtils.populate(user, map);
        } catch (Exception ignored) {
        }

        System.out.println(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
