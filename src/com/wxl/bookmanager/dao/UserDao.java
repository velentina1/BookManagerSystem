package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.BorrowDTO;
import com.wxl.bookmanager.bean.User;

import java.util.List;

public interface UserDao {
    User selectUser(String userName);

    User selectUserInfo(String userName);

    int getIdByName(String userName);

    boolean updateUser(User user, int userId);

    List<BorrowDTO> selectUserBorrowInfo(String userName);
}
