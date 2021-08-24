package com.aidan.servlet;

import com.aidan.util.CookieUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 实现过滤，即根据哪些路径发送
        Cookie cookie = new Cookie("path1", "path1");
        // getContextPath()得到工程路径
        cookie.setPath(req.getContextPath() + "/abc"); //   /工程路径/abc
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 方案一：
        // 1、先创建一个要修改的同名的Cookie对象
        // 2、在构造器，同时赋于新的Cookie值。
        // Cookie cookie = new Cookie("key1","newValue1");
        // 3、调用response.addCookie( Cookie ); 通知 客户端 保存修改
        // resp.addCookie(cookie);

        // 方案二：
        // 1、先查找到需要修改的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key2", req.getCookies());
        if (cookie != null) {
            // 2、调用setValue()方法赋于新的Cookie值。
            cookie.setValue("newValue2");
            // 3、调用response.addCookie()通知客户端保存修改
            resp.addCookie(cookie);
        }

        resp.getWriter().write("key1的Cookie已经修改好");
    }

    /**
     * 设置存活1个小时的Cooie
     */
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Cookie cookie = new Cookie("life3600", "life3600");
        /*
          默认值为负数：关闭浏览器删除
          正数：存活秒数
          0：当即死亡
         */
        cookie.setMaxAge(3600);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个存活一小时的Cookie");

    }

    /**
     * 马上删除一个Cookie
     */
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 先找到你要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());
        if (cookie != null) {
            // 调用setMaxAge(0);
            cookie.setMaxAge(0); // 表示马上删除，都不需要等待浏览器关闭
            // 调用response.addCookie(cookie);
            resp.addCookie(cookie);

            resp.getWriter().write("key4的Cookie已经被删除");
        }

    }

    /**
     * 默认的会话级别的Cookie
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookie = new Cookie("defalutLife", "defaultLife");
        cookie.setMaxAge(-1);//设置存活时间
        resp.addCookie(cookie);
    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            // getName方法返回Cookie的key（名）
            // getValue方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }

        Cookie iWantCookie = CookieUtils.findCookie("key1", cookies);

        // for (Cookie cookie : cookies) {
        // if ("key2".equals(cookie.getName())) {
        // iWantCookie = cookie;
        // break;
        // }
        // }
        // 如果不等于null，说明赋过值，也就是找到了需要的Cookie
        if (iWantCookie != null) {
            resp.getWriter().write("找到了需要的Cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        // 通知客户端保存Cookie（通过Set-Cookie响应头）
        resp.addCookie(cookie);

        // Cookie可以创建多个
        Cookie cookie1 = new Cookie("key2", "value2");
        resp.addCookie(cookie1);

        resp.getWriter().write("Cookie创建成功");
    }
}
