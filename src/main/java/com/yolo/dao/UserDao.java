package com.yolo.dao;

import com.yolo.domain.User;

public interface UserDao {
    User userLogin(String username,String password);

    int addUser(String username,String password);
}
