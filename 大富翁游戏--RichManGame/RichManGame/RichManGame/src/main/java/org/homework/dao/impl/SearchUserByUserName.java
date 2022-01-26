package org.homework.dao.impl;

import org.homework.dao.UserDao;
import org.homework.dao.searchUserByUserNameDao;
import org.homework.pojo.User;
import org.homework.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: SearchUserById
 * @projectName RichManGame
 * @description: 实现searchUserByUserNameDao, UserDao接口
 *               按名字查找全部内容和对比账号密码是否匹配 提供给登录和注册用
 * @date 2022/1/1914:59
 */
public class SearchUserByUserName implements searchUserByUserNameDao, UserDao {
    @Override
    public User searchUserByName(String userName) {
        String sql = "select userName,userId,gameCoins,passWord from userinfo where userName=?";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                User user = new User(rs.getInt("userId"), rs.getInt("gameCoins"),
                        rs.getString("userName"), rs.getString("passWord"));
                return user;
            }
            DbUtil.close(con, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User isLogin(String userName, String passWord) {
        User user = null;
        String sql = "select userName,userId,gameCoins,passWord from userinfo where userName=?";
        try {
            Connection con = DbUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, userName);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) {
                if(rs.getString("passWord").equals(passWord)) {
                    User user1 = new User(rs.getInt("userId"), rs.getInt("gameCoins"),
                            rs.getString("userName"), rs.getString("passWord"));
                    return user1;
                }
            }
            DbUtil.close(con, pst);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }
}
