package com.study.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
//        for (String s : hobby) {
//            System.out.println(s);
//        }
        System.out.println("hobby = " + Arrays.toString(hobby));
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobby = request.getParameterValues("hobby");
//        for (String s : hobby) {
//            System.out.println(s);
//        }
        System.out.println("hobby = " + Arrays.toString(hobby));
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }
}
