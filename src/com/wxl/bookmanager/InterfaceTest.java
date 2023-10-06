package com.wxl.bookmanager;

import com.wxl.bookmanager.service.AdminService;
import com.wxl.bookmanager.service.UserService;

import java.util.Objects;
import java.util.Scanner;

public class InterfaceTest {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        UserService userService = new UserService();
        //一般路过控制台输出
        System.out.println("---------图书借阅系统----------");
        System.out.println("------请选择您的登录身份：------");
        System.out.println("------1.管理员----2.用户------");
        System.out.println("--------选择0退出本系统--------");
        Scanner scanner = new Scanner(System.in);
        String UserType = scanner.nextLine();
        //int还是太麻烦了
        while (!Objects.equals(UserType, "1") && !Objects.equals(UserType, "2") && !Objects.equals(UserType, "0")){
            System.out.print("输入错误！请重新输入:");
            UserType = scanner.nextLine();
        }
        //管理员部分
        if (UserType.equals("1")){
            System.out.println("--------请登录：--------");
            boolean adminYes = adminService.login();
            while (!adminYes){
                System.out.println("登录失败，请重新登录！");
                adminYes = adminService.login();
            }

            while (true) {
                System.out.println("------------请选择功能-----------");
                System.out.println("----1.添加普通用户----------------");
                System.out.println("----2.修改普通用户密码-------------");
                System.out.println("----3.删除普通用户-----------------");
                System.out.println("----4.查询指定用户的信息及借阅信息----");
                System.out.println("----5.添加图书--------------------");
                System.out.println("----6.删除图书--------------------");
                System.out.println("----7.修改图书--------------------");
                System.out.println("----8.查询图书--------------------");
                System.out.println("----9.添加借阅信息-----------------");
                System.out.println("----10.查询所有借阅信息-------------");
                System.out.println("----11.办理还书-------------------");
                System.out.println("请输入数字 1-11选择对应功能，输入0退出：");

                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                }
                switch (input) {
                    case 1:
                        adminService.addUser();
                        continue;
                    case 2:
                        adminService.updatePassword();
                        continue;
                    case 3:
                        adminService.deleteUser();
                        continue;
                    case 4:
                        adminService.selectUserInfo();
                        continue;
                    case 5:
                        adminService.addBook();
                        continue;
                    case 6:
                        adminService.deleteBook();
                        continue;
                    case 7:
                        adminService.updateBook();
                        continue;
                    case 8:
                        adminService.selectBook();
                        continue;
                    case 9:
                        adminService.addBorrowInfo();
                        continue;
                    case 10:
                        adminService.selectAllBorrowInfo();
                        continue;
                    case 11:
                        adminService.returnBook();
                        continue;
                    default:
                        System.out.println("输入错误，请重新输入数字 1-11。");
                }
            }
        }
        //用户部分
        else if (UserType.equals("2")){
            System.out.println("--------请登录：--------");
            System.out.println("请输入用户名:");
            String userName = scanner.next();
            System.out.println("请输入密码：");
            String password = scanner.next();
            boolean userYes = userService.login(userName,password);
            while (!userYes){
                System.out.println("登录失败，请重新登录！");
                userYes = adminService.login();
            }
            System.out.println("登陆成功！");
            while (userYes) {
                System.out.println("------------请选择功能------------");
                System.out.println("----1.查看个人信息----------------");
                System.out.println("----2.修改个人信息----------------");
                System.out.println("----3.修改密码--------------------");
                System.out.println("----4.查看所有图书信息--------------");
                System.out.println("----5.查看所有已借阅信息-------------");
                System.out.println("----6.查询自己是否存在逾期-----------");
                System.out.println("请输入数字 1-6选择对应功能，输入0退出：");

                int input = scanner.nextInt();
                if (input == 0) {
                    break;
                }
                switch (input) {
                    case 1:
                        userService.selectUserInfo(userName, password);
                        continue;
                    case 2:
                        userService.updateUserInfo(userName, password);
                        continue;
                    case 3:
                        userService.updatePassword(userName, password);
                        continue;
                    case 4:
                        userService.bookInfo();
                        continue;
                    case 5:
                        userService.selectUserBorrowInfo(userName, password);
                        continue;
                    case 6:
                        userService.WhetherUserOverdue(userName, password);
                        continue;
                    default:
                        System.out.println("无效的选择，请重新输入。");
                }
            }
        }
        //退出
        else {
            System.out.println("感谢您的使用！");
        }
    }
}
