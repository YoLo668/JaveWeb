package com.yolo.dao.impl;

import com.yolo.dao.UserDao;
import com.yolo.domain.User;
import com.yolo.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User userLogin(String username,String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            //获取连接
            conn = JDBCUtil.getConnection();
            //获取预编译的数据库操作对象
            ps = conn.prepareStatement("select * from t_user where username=? and password=?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs =  ps.executeQuery();
            if (rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JDBCUtil.closeReources(conn,ps,rs);
        return user;
    }
}
