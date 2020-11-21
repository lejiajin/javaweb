package com.study.dao;

import com.study.domain.User;

import java.sql.SQLException;

public interface UserDao {
    public User queryUserByUsername(String username) throws SQLException;
    public int saveUser(User user) throws SQLException;
    public User queryUserByUsernameAndPassword(String username,String password) throws SQLException;
}
