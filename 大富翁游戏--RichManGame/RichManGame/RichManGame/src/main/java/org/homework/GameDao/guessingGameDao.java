package org.homework.GameDao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: guessingGameDao
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1916:41
 */
public interface guessingGameDao {
    void guessingGame(int userID) throws IOException, SQLException;
}
