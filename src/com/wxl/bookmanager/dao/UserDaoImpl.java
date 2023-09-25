package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.User;

public class UserDaoImpl extends BaseDao implements  UserDao{
    @Override
    public User selectUser(String userName) {
        String sql = "select * from book_user where userName = ?";
        return QueryOne(User.class,sql,userName);
    }
}
