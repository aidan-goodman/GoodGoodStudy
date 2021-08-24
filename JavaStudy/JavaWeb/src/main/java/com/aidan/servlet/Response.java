package com.aidan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Response extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理
        System.out.println("操作重定向");

        // 设置状态码
        resp.setStatus(302);
        // 在响应头添加地址
        resp.setHeader("Location", "http://localhost:8080/JavaWeb/r2");

        // 第二种重定向方式
        //resp.sendRedirect("http://localhost:8080/JavaWeb/r2");
    }
}
