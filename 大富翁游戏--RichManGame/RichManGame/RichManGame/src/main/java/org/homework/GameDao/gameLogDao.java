package org.homework.GameDao;

import org.homework.pojo.GameLog;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Jackie_chen
 * @title: GameLogDao
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/2011:47
 */
public interface gameLogDao {
    void addGameLog(String gameName, int user_id, int coinsChanges);

    List<GameLog> getAllGameLog(int user_id) throws SQLException;
}
