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

    @Override
    public int selectBorrowCount(int userId) {
        String sql = "SELECT * FROM borrowinfo WHERE userId = ? AND isreturn = 0";
        List<BorrowInfo> borrowInfos = QueryAll(BorrowInfo.class,sql,userId);
        return borrowInfos.size();
    }

    @Override
    public List<BorrowInfo> selectBorrowTimeInfo(int userId) {
        String sql = "SELECT * FROM borrowinfo WHERE userId = ? AND DATEDIFF(NOW(),borrowtime)>60 AND isreturn = 0 ";
        return QueryAll(BorrowInfo.class,sql,userId);
    }

    @Override
    public boolean addBorrowInfo(BorrowInfo borrowInfo) {
        String sql = "insert into borrowInfo(userId,bookId,borrowtime,isreturn) values(?,?,?,?)";
        return update(sql,borrowInfo.getUserId(),borrowInfo.getBookId(),borrowInfo.getBorrowtime(),borrowInfo.getIsreturn());
    }
}
