package com.study.service.impl;

import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import com.study.domain.User;
import com.study.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl() {
    };
    @Override
    public void registUser(User user) throws SQLException {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) throws SQLException {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) throws SQLException {
        if (userDao.queryUserByUsername(username)==null) {
            return  false;
        }
        return true;
    }
}
