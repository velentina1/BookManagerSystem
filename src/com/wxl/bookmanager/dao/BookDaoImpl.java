package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.Book;

import java.util.List;


public class BookDaoImpl extends BaseDao implements BookDao{
    @Override
    public int getIdByName(String bookName) {
        String sql = "select * from book where bookName = ?";
        Book book = QueryOne(Book.class,sql,bookName);
//        System.out.println(book.getBookId());
        return book.getBookId();
    }

    @Override
    public List<Book> selectAllBook() {
        String sql = "select * from book";
        List<Book> books = QueryAll(Book.class, sql);
        return books;
    }

    @Override
    public List<Book> selectBookByName(String bookName) {
        String sql = "select * from book where bookName like ?";
        bookName = "%" + bookName + "%";
        List<Book> books = QueryAll(Book.class, sql, bookName);
        return books;
    }
}
