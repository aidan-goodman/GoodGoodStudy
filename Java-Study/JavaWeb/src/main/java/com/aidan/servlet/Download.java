package com.aidan.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class Download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取客户端下载的文件名
        String downloadFileName = "GitHub.jpg";

        // 2. 读取要下载的文件内容
        ServletContext servletContext = getServletContext();
        // 工程的映射url为web目录
        InputStream resourceAsStream = servletContext.getResourceAsStream("/imgs/" + downloadFileName);
        // 响应的输出流
        OutputStream outputStream = resp.getOutputStream();

        // 3. 通过响应头告诉客户端返回的数据类型，和声明数据作用为下载
        String mimeType = servletContext.getMimeType("/imgs/" + downloadFileName);
        System.out.println("获取的文件类型为：" + mimeType);
        resp.setContentType(mimeType);

        /** 不声明下载，文件会直接显示在浏览器
         * attachment表示附件，也就是用作下载
         * fileName用于指定文件
         */
        resp.setHeader("Content-Disposition", "attachment; fileName=" + downloadFileName);

        // 4. 将文件回传给客户端
        // 使用commons-IO.jar的工具类将流输出
        IOUtils.copy(resourceAsStream, outputStream);

    }
}
