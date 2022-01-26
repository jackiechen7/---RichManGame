package org.homework.test;

import org.homework.GameDao.Impl.GuessingGame;
import org.homework.GameDao.Impl.NumberGuessingGame;
import org.homework.GameDao.Impl.UserInfoImpl;
import org.homework.dao.impl.MenuLogin;
import org.homework.dao.impl.MenuRegister;
import org.homework.pojo.User;
import org.homework.service.impl.MenuSelectImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: GameRun
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1916:32
 */
public class GameRun {
    public  void run(User user) throws IOException, SQLException {
        while (true) {
            System.out.println("********************Item List********************");
            System.out.println("                 1、Guessing game");
            System.out.println("                 2、Number Guessing Game");
            System.out.println("                 3、User Info");
            System.out.println("                 4、Out System");
            System.out.println("              Other Digital exit systems");
            System.out.println("***************************************************");
            //Instantiate menu selection class
            MenuSelectImpl menuSelect = new MenuSelectImpl();
            int menuID = menuSelect.menuSelect();
            SystemRun systemRun = new SystemRun();
            GuessingGame gg = new GuessingGame();
            NumberGuessingGame ngg = new NumberGuessingGame();
            UserInfoImpl userInfo = new UserInfoImpl();
            switch (menuID) {
                case 1 :
                    gg.guessingGame(user.getUserId());
                    break;
                case 2 :
                    ngg.numberGuessingGame(user.getUserId());
                    break;
                case 3 :
                    userInfo.userInfo(user.getUserId());
                    break;

                case 4 :
                    systemRun.run();



            }



        }
    }
}
