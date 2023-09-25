package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.Admin;
import com.wxl.bookmanager.bean.User;

public class AdminDaoImpl extends BaseDao implements AdminDao{
    @Override
    public Admin selectAdmin(String adminName) {
        String sql = "select * from admin where adminName = ?";
        return QueryOne(Admin.class,sql,adminName);
    }

    @Override
    public boolean addUser(User user) {
        String sql = "insert into book_user (userName,password,phone,birthday)" +
                " VALUES(?,?,?,?)";
        return update(sql,user.getUserName(),user.getPassword(),user.getPhone(),user.getBirthday());
    }

    @Override
    public boolean updatePWD(String userName, String pwd1) {
        String sql = "update book_user set password = ? where userName = ?";
        return update(sql,pwd1,userName);
    }

    @Override
    public boolean deleteUser(String userName) {
        String sql = "delete from book_user where userName = ?";
        return update(sql,userName);
    }
}
