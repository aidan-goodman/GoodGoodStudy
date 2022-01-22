package com.aidan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if ("aidan".equals(username) && "123456".equals(password)) {
            // 登录 成功
            /*Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 7);//当前Cookie一周内有效
            resp.addCookie(cookie);
            System.out.println("登录 成功");*/

            req.getSession().setAttribute("userName", username);
            resp.getWriter().write("登录成功");
        } else {
            // 登录 失败
//            System.out.println("登录 失败");
            req.getRequestDispatcher("/login.html").forward(req, resp);
        }

    }
}
