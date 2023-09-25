package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.Book;


public class BookDaoImpl extends BaseDao implements BookDao{
    @Override
    public int getIdByName(String bookName) {
        String sql = "select * from book where bookName = ?";
        Book book = QueryOne(Book.class,sql,bookName);
//        System.out.println(book.getBookId());
        return book.getBookId();
    }
}
