package org.homework.GameDao.Impl;

import org.homework.GameDao.gameLogDao;
import org.homework.pojo.GameLog;
import org.homework.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jackie_chen
 * @title: GameLogImpl
 * @projectName RichManGame
 * @description: 实现添加和查询记录
 * @date 2022/1/2011:48
 */
public class GameLogImpl implements gameLogDao {
    @Override
    public void addGameLog(String gameName, int user_id, int coinsChanges) {
        String sql = "insert into gameinfo(gameName,user_id,coinsChanges)values(?,?,?)";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, gameName);
            pst.setInt(2, user_id);
            pst.setInt(3, coinsChanges);
            //Returns false if the first result is an update count or if there is no result
            if(!pst.execute()) {
                System.out.println("ADD success!");
            }
            DbUtil.close(con, pst);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("cannot add" + e.getMessage());
        }
    }

    @Override
    public List<GameLog> getAllGameLog(int user_id) throws SQLException {
        List<GameLog> lst= new ArrayList<>();
        GameLog gameLog =new GameLog();
        String sql = "select * from gameinfo where user_id=?";
        Connection con = DbUtil.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, user_id);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            GameLog gameLog1 = new GameLog();
            gameLog1.setId(rs.getInt("id"));
            gameLog1.setGameName(rs.getString("gameName"));
            gameLog1.setUser_id(rs.getInt("user_id"));
            gameLog1.setCoinsChanges(rs.getInt("coinsChanges"));
            gameLog1.setCreateTime(rs.getString("createTime"));
            lst.add(gameLog1);
        }
        return lst;
    }
}
