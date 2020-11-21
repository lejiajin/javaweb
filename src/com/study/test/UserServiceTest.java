package com.study.test;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService=new UserServiceImpl();
    @Test
    public void registUser() throws SQLException {
        userService.registUser(new User(null,"4445","4445","445"));
    }

    @Test
    public void login() throws SQLException {
        System.out.println(userService.login(new User(null, "123", "123", null)));
    }

    @Test
    public void existsUsername() throws SQLException {
        if (userService.existsUsername("111123")) {
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}