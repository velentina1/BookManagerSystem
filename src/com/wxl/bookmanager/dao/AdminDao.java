package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.Admin;
import com.wxl.bookmanager.bean.BorrowDTO;
import com.wxl.bookmanager.bean.User;

import java.util.List;

public interface AdminDao {
    //查询管理员信息
    Admin selectAdmin(String adminName);

    //增加用户
    boolean addUser(User user);

    boolean updatePWD(String userName, String pwd1);

    boolean deleteUser(String userName);
    List <BorrowDTO> selectUserBorrowInfo(String userName);
}
