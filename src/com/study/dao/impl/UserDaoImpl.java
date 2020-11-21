package com.study.dao.impl;

import com.study.dao.UserDao;
import com.study.domain.User;

import java.sql.SQLException;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) throws SQLException {
        String sql="select*from user where  username=?";
        return queryForOne(User.class,sql,username);

    }

    @Override
    public int saveUser(User user) throws SQLException {
        String sql="insert into user(username,password,mail) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getMail());
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) throws SQLException {
        String sql="select*from user where  username=? and password=?";
        return queryForOne(User.class,sql,username,password);
    }
}
