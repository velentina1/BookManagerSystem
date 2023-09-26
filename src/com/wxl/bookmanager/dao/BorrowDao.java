package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.BorrowInfo;

import java.util.List;

public interface BorrowDao {
    //根据图书id查看图书是否被借阅
    boolean selectBorrowInfoById(int bookId);

    int selectBorrowCount(int userId);

    List<BorrowInfo> selectBorrowTimeInfo(int userId);

    boolean addBorrowInfo(BorrowInfo borrowInfo);
}
