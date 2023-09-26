package com.wxl.bookmanager.dao;

import com.wxl.bookmanager.bean.BorrowDTO;
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
        String sql = "SELECT * FROM borrowinfo WHERE userId = ? AND DATEDIFF(NOW(),borrowtime)>60 AND isreturn = 0";
        return QueryAll(BorrowInfo.class,sql,userId);
    }

    @Override
    public boolean addBorrowInfo(BorrowInfo borrowInfo) {
        String sql = "insert into borrowInfo(userId,bookId,borrowtime,isreturn) values(?,?,?,?)";
        return update(sql,borrowInfo.getUserId(),borrowInfo.getBookId(),borrowInfo.getBorrowtime(),borrowInfo.getIsreturn());
    }

    @Override
    public List<BorrowDTO> selectAllInfo() {
        String sql = "select u.userName as userName, u.phone as phone, b2.bookName as bookName, b1.borrowtime as borrowtime, b1.returntime as returntime from book_user as u left join borrowinfo as b1 on u.userId = b1.userId left join book as b2 on b1.bookId = b2.bookId";
        return QueryAll(BorrowDTO.class,sql);
    }

    @Override
    public boolean updateBorrowInfo(BorrowInfo borrowInfo) {
        String sql = "update borrowinfo set returntime = ?, isreturn = ? where userId = ? and bookId = ?";
        return update(sql,borrowInfo.getReturntime(),borrowInfo.getIsreturn(),borrowInfo.getUserId(),borrowInfo.getBookId());
    }
}
