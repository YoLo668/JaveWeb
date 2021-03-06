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

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到用户登录");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = MD5Util.getMD5(password);
        UserService userService = new UserServiceImpl();

        User user = userService.userLogin(username, password);

        //说明用户存在
        if (user!=null){
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        //用户不存在
        }else {
            request.setAttribute("error","用户不存在,请您重新登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
