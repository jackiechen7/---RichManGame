package org.homework.GameDao.Impl;

import org.homework.GameDao.userInfoDao;
import org.homework.pojo.GameLog;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jackie_chen
 * @title: UserInfoImpl
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/2014:25
 */
public class UserInfoImpl implements userInfoDao {
    @Override
    public void userInfo(int user_id) throws SQLException {
        GameLogImpl gameLog = new GameLogImpl();
        List<GameLog> list = gameLog.getAllGameLog(user_id);
        System.out.println("您的日志信息为：");
        for(int i = 0; i < list.size(); i++){
            System.out.println("\t" + list.get(i));
        }
        SetCoins fc = new SetCoins();
        int coins = fc.findCoins(user_id);
        System.out.println("您的游戏币个数为： " + coins);
    }
}
