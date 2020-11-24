package com.study.web;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;

public class UserServlet extends HttpServlet {
    private UserService userService= new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
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

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcde".equalsIgnoreCase(code)) {
            try {
                if (userService.existsUsername(username)) {
                    System.out.println("用户名已存在");
                    req.setAttribute("msg","用户名已存在");
                    req.setAttribute("username",username);
                    req.setAttribute("email",email);
                    req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);

                }else {
                    userService.registUser(new User(null,username,password,email));
                    req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req,resp);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            System.out.println("验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter("action");
        try {
            Method method=this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            try {
                method.invoke(this, req, resp);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
