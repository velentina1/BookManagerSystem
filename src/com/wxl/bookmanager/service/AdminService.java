package com.wxl.bookmanager.service;

import com.wxl.bookmanager.bean.Admin;
import com.wxl.bookmanager.bean.Book;
import com.wxl.bookmanager.bean.BorrowDTO;
import com.wxl.bookmanager.bean.User;
import com.wxl.bookmanager.dao.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AdminService {
    Scanner scanner = new Scanner(System.in);
    AdminDao adminDao = new AdminDaoImpl();
    UserDao userDao = new UserDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    BorrowDao borrowDao = new BorrowDaoImpl();
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
    //删除用户
    public boolean deleteUser(){
        System.out.println("请输入要删除的用户名：");
        String userName = scanner.next();
        System.out.println("你确定删除" + userName + "这个用户信息吗？Y/N");
        String ok = scanner.next();
        if ("N".equals(ok)) {
            return false;
        }else if (!"Y".equals(ok)){
            System.out.println("请规范输入");
            return false;
        } else {
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
    //增加图书
    public boolean addBook(){
        System.out.println("请输入要增加书籍的名称：");
        String bookName = scanner.next();
        System.out.println("请输入要增加书籍的出版社：");
        String publisher = scanner.next();
        System.out.println("请输入要增加书籍的作者：");
        String author = scanner.next();
        System.out.println("请输入要增加书籍的类别：");
        String bookType = scanner.next();
        System.out.println("请输入要增加书籍的剩余数量：");
        int remain = scanner.nextInt();

        Book book = new Book();
        book.setBookName(bookName);
        book.setPublisher(publisher);
        book.setAuthor(author);
        book.setBookType(bookType);
        book.setRemain(remain);

        boolean result = adminDao.addBook(book);

        if(result){
            System.out.println("添加书籍成功");
            return true;
        }else {
            System.out.println("添加书籍失败");
            return false;
        }
    }
    //删除图书
    public boolean deleteBook(){
        System.out.println("请输入你要删除的图书的名称");
        String bookName = scanner.next();
        System.out.println("你确定删除" + bookName + "这本书籍信息吗？Y/N");
        String ok = scanner.next();
        if ("N".equals(ok)){
            return false;
        }else if (!"Y".equals(ok)){
            System.out.println("请规范输入");
            return false;
        } else {
            //判断图书借阅情况
            int bookId = bookDao.getIdByName(bookName);
            System.out.println(bookId);
            boolean rs = borrowDao.selectBorrowInfoById(bookId);
            if (rs){
                System.out.println("该图书被借阅不能删除！");
                return false;
            }else {
                //删除
                boolean result = adminDao.deleteBookByName(bookName);
                if (result) {
                    System.out.println("删除成功");
                    return true;
                } else {
                    System.out.println("删除失败");
                    return false;
                }
            }
        }
    }
    //修改图书

    //查询图书
}
