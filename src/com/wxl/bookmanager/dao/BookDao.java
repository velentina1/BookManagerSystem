package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.Book;

import java.util.List;

public interface BookDao {
    //通过图书名称获取图书id
    int getIdByName(String bookName);

    //查询所有书籍
    List<Book> selectAllBook();
    //根据名称获取书籍
    List<Book> selectBookByName(String bookName);
}
