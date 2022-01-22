package com.aidan.filter;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        filterConfig.getFilterName();
        filterConfig.getInitParameter("username");
        filterConfig.getServletContext();
    }

    /**
     * 专门用来进行拦截请求
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession httpSession = httpServletRequest.getSession();
        Object session = httpSession.getAttribute("userName");
        // 如果会话获取为空
        if (session == null) {
            servletRequest.getRequestDispatcher("/login.html").forward(servletRequest, servletResponse);
            return;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
