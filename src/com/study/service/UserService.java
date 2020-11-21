package com.study.service;

import com.study.domain.User;

import java.sql.SQLException;

public interface UserService {
    /*
    * @param user
    * */
    public  void registUser(User user) throws SQLException;
    public User login(User user) throws SQLException;
    public boolean existsUsername(String username) throws SQLException;
}
