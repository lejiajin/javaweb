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

public class RegistServlet extends HttpServlet {
    private UserService userService= new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)) {
            try {
                if (userService.existsUsername(username)) {
                    System.out.println("用户名已存在");
                    req.getRequestDispatcher("pages/user/regist.html").forward(req,resp);

                }else {
                    userService.registUser(new User(null,username,password,email));
                    req.getRequestDispatcher("pages/user/regist_success.html").forward(req,resp);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("验证码错误");
            req.getRequestDispatcher("pages/user/regist.html").forward(req,resp);
        }


    }
}
