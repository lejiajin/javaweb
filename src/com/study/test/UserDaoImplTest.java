package com.study.test;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import com.study.domain.User;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    UserDaoImpl userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() throws SQLException {

        if (userDao.queryUserByUsername("123")==null) {
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在");
        }

    }

    @Test
    public void saveUser() throws SQLException {
        System.out.println(userDao.saveUser(new User(null, "121113", "123", "123")));
    }

    @Test
    public void queryUserByUsernameAndPassword() throws SQLException {
        if (userDao.queryUserByUsernameAndPassword("123","1213")==null) {
            System.out.println("用户名或密码错误，登录失败");

        }else{
            System.out.println("查询成功");
        }
    }
}