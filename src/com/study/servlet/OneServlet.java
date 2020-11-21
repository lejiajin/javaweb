package com.study.servlet;

import javax.servlet.ServletContext;
import java.io.IOException;

public class OneServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String servletName = getServletConfig().getServletName();

        System.out.println(servletName);
        String username = getServletConfig().getInitParameter("url");
        System.out.println(username);

        System.out.println(getServletConfig().getServletContext().getInitParameter("study"));
        String contextPath = getServletConfig().getServletContext().getContextPath();
        System.out.println(contextPath);
        System.out.println("123"+getServletConfig().getServletContext().getRealPath("/"));
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("name","lejiajn");
        Object name = servletContext.getAttribute("name");
        System.out.println(name);
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        System.out.println("requestURI = " + requestURI);
        System.out.println(request.getRemoteHost());
        System.out.println(request.getHeader("Content-Type"));
        System.out.println(request.getMethod());


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
