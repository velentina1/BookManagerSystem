package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.BorrowInfo;

public interface BorrowDao {
    //根据图书id查看图书是否被借阅
    boolean selectBorrowInfoById(int id);
}
