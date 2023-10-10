package com.wxl.bookmanager;

import com.wxl.bookmanager.bean.User;
import com.wxl.bookmanager.dao.UserDao;
import com.wxl.bookmanager.dao.UserDaoImpl;
import com.wxl.bookmanager.service.UserService;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class ServletTest1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        UserDao userDao = new UserDaoImpl();
        User user = userDao.selectUser(userName);
        if (Objects.equals(userName, "") || Objects.equals(password, "")) {
            // 输入为空的情况
            System.out.println("输入为空！");
            response.getWriter().write("输入为空！");
        } else if (user == null) {
            // 用户不存在的情况
            System.out.println("用户不存在！");
            response.getWriter().write("用户不存在");
        } else {
            String userPassword = user.getPassword();
            if (userPassword.equals(password)) {
                // 登陆成功
                System.out.println("登陆成功");
                response.getWriter().write("登陆成功");
            } else {
                // 密码错误
                System.out.println("密码错误");
                response.getWriter().write("密码错误");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
