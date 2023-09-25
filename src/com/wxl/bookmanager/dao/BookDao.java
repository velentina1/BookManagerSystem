package com.wxl.bookmanager.dao;

public interface BookDao {
    //通过图书名称获取图书id
    int getIdByName(String bookName);
}
