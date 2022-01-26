package org.homework;

import static org.junit.Assert.assertTrue;

import org.homework.GameDao.Impl.GameLogImpl;
import org.homework.pojo.GameLog;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws SQLException {
        GameLog gameLog1 = new GameLog();
        GameLogImpl gameLog = new GameLogImpl();
        int a = 2;

        List<GameLog> list = gameLog.getAllGameLog(a);
        for(int i = 0; i < list.size(); i++){
            System.out.println("\t" + list.get(i));
        }
        assertTrue( true );
    }
}
