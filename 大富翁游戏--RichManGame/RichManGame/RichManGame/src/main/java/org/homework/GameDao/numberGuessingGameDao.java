package org.homework.GameDao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: numberGuessingGameDao
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1921:39
 */
public interface numberGuessingGameDao {
    void numberGuessingGame(int userId) throws IOException, SQLException;
}
