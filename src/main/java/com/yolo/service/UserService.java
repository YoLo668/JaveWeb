package com.yolo.service;

import com.yolo.domain.User;

public interface UserService {
    User userLogin(String username,String password);
    int addUser(String username,String password);
}
