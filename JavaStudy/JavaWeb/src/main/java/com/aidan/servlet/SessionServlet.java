package com.aidan.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionServlet extends BaseServlet {
    /**
     * 往Session中保存数据
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经往Session中保存了数据");

    }

    /**
     * 获取Session域中的数据
     */
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取出key1的数据是：" + attribute);
    }


    /**
     * 存活时间的控制
     * 默认时长为1800秒
     * invalidate()方法杀死会话
     */
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 获取了Session的默认超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("Session的默认超时时长为：" + maxInactiveInterval + " 秒 ");

    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 先获取Session对象
        HttpSession session = req.getSession();
        // 设置当前Session3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前Session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 先获取Session对象
        HttpSession session = req.getSession();
        // 让Session会话马上超时
        session.invalidate();

        resp.getWriter().write("Session已经设置为超时（无效）");
    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 创建和获取Session会话对象
        HttpSession session = req.getSession();
        // 判断 当前Session会话，是否是新创建出来的
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识 id
        String id = session.getId();

        resp.getWriter().write("得到的Session，它的id是：" + id + " <br /> ");
        resp.getWriter().write("这个Session是否是新创建的：" + isNew + " <br /> ");
    }
}
