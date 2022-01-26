package org.homework.GameDao;

/**
 * @author Jackie_chen
 * @title: findCoinsDao
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1916:44
 */
public interface setCoinsDao {
    int findCoins(int userId);
    void updateCoins(int coins, int userId);
}
