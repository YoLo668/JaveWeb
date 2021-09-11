package com.yolo.service.impl;

import com.yolo.dao.UserDao;
import com.yolo.dao.impl.UserDaoImpl;
import com.yolo.domain.User;
import com.yolo.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){
        this.userDao = new UserDaoImpl();
    }
    @Override
    public User userLogin(String username,String password) {
        User user = null;

        user = userDao.userLogin(username,password);

        return user;
    }

    @Override
    public int addUser(String username, String password) {
        int count = 0;

        count = userDao.addUser(username,password);

        return count;
    }
}
