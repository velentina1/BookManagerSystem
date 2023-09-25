package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.User;

public interface UserDao {
    User selectUser(String userName);
}
