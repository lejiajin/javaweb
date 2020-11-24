package com.study.web;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(123);
        try {
            User login = userService.login(new User(null, username, password, null));
            if (login==null) {
                req.setAttribute("msg","用户名或密码错误！");
                req.setAttribute("username",username);
                req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
