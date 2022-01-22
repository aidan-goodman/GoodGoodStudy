package com.aidan.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("查看参数：" + username);

        // 标记请求
        req.setAttribute("flag", "已标记");

        // 转发路径分配（转发路径必须斜杠开头）
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/s2");

        // 进行转发
        requestDispatcher.forward(req, resp);
    }
}
