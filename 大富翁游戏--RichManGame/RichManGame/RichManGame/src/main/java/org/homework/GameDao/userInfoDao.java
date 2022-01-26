package org.homework.GameDao;

import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: userInfo
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/2014:23
 */
public interface userInfoDao {
    void userInfo(int user_id) throws SQLException;
}
