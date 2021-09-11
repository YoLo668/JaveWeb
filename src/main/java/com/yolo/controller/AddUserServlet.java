package com.yolo.controller;

import com.yolo.domain.User;
import com.yolo.service.UserService;
import com.yolo.service.impl.UserServiceImpl;
import com.yolo.util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户注册");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!username.trim().equals("")&&username!=null && !password.trim().equals("")&&password!=null){
            //将密码明文形式转换为密文
            password = MD5Util.getMD5(password);
            UserService userService = new UserServiceImpl();
            int count = userService.addUser(username,password);
            System.out.println(count);
            //说明用户存在
            if (count==1){
                //注册成功,跳转到登录页
                response.sendRedirect(request.getContextPath()+"/login.jsp");
                //用户不存在
            }
        }else{
            request.setAttribute("addError","注册失败,请您重新注册");
            request.getRequestDispatcher("/add.jsp").forward(request,response);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
