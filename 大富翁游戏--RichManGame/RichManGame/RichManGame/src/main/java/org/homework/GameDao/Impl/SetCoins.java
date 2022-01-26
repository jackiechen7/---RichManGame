package org.homework.GameDao.Impl;

import org.homework.GameDao.setCoinsDao;
import org.homework.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: FindCoins
 * @projectName RichManGame
 * @description: 实现setCoinsDao接口，在数据库查找和更新游戏币的功能
 * @date 2022/1/1916:44
 */
public class SetCoins implements setCoinsDao {

    @Override
    public int findCoins(int userId) {
        String sql = "select gameCoins from userinfo where userId=?";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt("gameCoins");
            }
            DbUtil.close(con, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public void updateCoins(int coins, int userId) {
        String sql = "update userinfo set gameCoins=? where userId=?";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,coins);
            pst.setInt(2,userId);
            pst.execute();
            //test
//            if(!pst.execute()) {
//               System.out.println("update success！");
//           }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("update fail" + e.getMessage());
        }
    }
}
