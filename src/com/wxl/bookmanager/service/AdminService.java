package com.wxl.bookmanager.service;

import com.wxl.bookmanager.bean.Admin;
import com.wxl.bookmanager.bean.BorrowDTO;
import com.wxl.bookmanager.bean.User;
import com.wxl.bookmanager.dao.AdminDao;
import com.wxl.bookmanager.dao.AdminDaoImpl;
import com.wxl.bookmanager.dao.UserDao;
import com.wxl.bookmanager.dao.UserDaoImpl;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdminService {
    Scanner scanner = new Scanner(System.in);
    AdminDao adminDao = new AdminDaoImpl();
    UserDao userDao = new UserDaoImpl();
    //登录方法
    public boolean login(){
        System.out.println("请输入用户名:");
        String userName = scanner.next();
        System.out.println("请输入和密码：");
        String password = scanner.next();

        if (userName == null || userName == "") {
            System.out.println("用户名不能为空");
            return false;
        }
        if ("admin".equals(userName)){
            Admin admin = adminDao.selectAdmin(userName);
            String adminPassword = admin.getAdminPassword();;
            if (adminPassword.equals(password)) {
                System.out.println("登陆成功");
                return  true;
            } else {
                System.out.println("密码错误");
                return  false;
            }
        }  else {
            User user =  userDao.selectUser(userName);
            if (user == null){
                System.out.println("用户名不存在，请联系管理员！");
                return false;
            }
            String userPassword = user.getPassword();
            if (password.equals(userPassword)) {
                System.out.println("登陆成功");
                return true;
            }
            System.out.println("密码错误");
            return false;
        }
    }

    //增加用户
    public boolean addUser(){
        System.out.println("请输入添加的用户名：");
        String username = scanner.next();
        System.out.println("请输入添加的密码：");
        String password = scanner.next();
        System.out.println("请输入添加的手机：");
        String phone = scanner.next();
        System.out.println("请输入添加的生日：");
        String birthday = scanner.next();
        User user = new User(username,password,phone,birthday);
        boolean result = adminDao.addUser(user);
        if (result) {
            System.out.println("添加成功");
            return true;
        } else {
            System.out.println("添加失败");
            return false;
        }

    }
    //修改密码
    public boolean updatePassword(){
        System.out.println("请输入你要修改密码的用户名：");
        String userName = scanner.next();
        System.out.println("请输入新密码：");
        String pwd1 = scanner.next();
        System.out.println("请在此输入新密码：");
        String pwd2 = scanner.next();
        if (!pwd1.equals(pwd2)) {
            return false;
        }
        boolean result = adminDao.updatePWD(userName,pwd1);
        if (result){
            System.out.println("修改密码成功");
            return true;
        }else {
            System.out.println("修改密码失败");
            return false;
        }
    }
    //删除
    public boolean deleteUser(){
        System.out.println("请输入要删除的用户名：");
        String userName = scanner.next();
        System.out.println("你确定删除" + userName + "这个用户信息吗？Y/N");
        String ok = scanner.next();
        if ("N".equals(ok)) {
            return false;
        }else {
            boolean result = adminDao.deleteUser(userName);
            if (result){
                System.out.println("删除成功");
                return true;
            }else {
                System.out.println("删除失败");
                return false;
            }
        }
    }
    //查询指定用户的信息及借阅信息
    public void selectUserInfo(){
        System.out.println("请输入要查询信息的用户名");
        String userName = scanner.next();
        List<BorrowDTO> borrowDTOList = adminDao.selectUserBorrowInfo(userName);
        if (borrowDTOList != null){
            System.out.println(borrowDTOList);
        }else {
            System.out.println("没有查询到对应的数据！");
        }
    }
}
