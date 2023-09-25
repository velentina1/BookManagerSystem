package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.BorrowInfo;

import java.util.List;

public class BorrowDaoImpl extends BaseDao implements BorrowDao{
    @Override
    public boolean selectBorrowInfoById(int id) {
        String sql = "select * from borrowinfo where bookId = ?";
        List<BorrowInfo> borrowInfos = QueryAll(BorrowInfo.class,sql,id);
//        System.out.println(borrowInfos.size());
        return borrowInfos.size() > 0;
    }
}
