package top.aidan.admin.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aidan on 2021/9/28 9:26
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

// @WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.getWriter().write("Servlet 请求成功");
   }
}
