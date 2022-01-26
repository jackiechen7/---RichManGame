package org.homework.GameDao.Impl;

import org.homework.GameDao.numberGuessingGameDao;
import org.homework.dao.impl.MenuRegister;
import org.homework.pojo.User;
import org.homework.service.impl.GetEnter;
import org.homework.test.GameRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Jackie_chen
 * @title: numberGuessingGame
 * @projectName RichManGame
 * @description: 实现numberGuessingGameDao接口，并且实时更新游戏币
 * @date 2022/1/1921:40
 */
public class NumberGuessingGame implements numberGuessingGameDao {
    @Override
    public void numberGuessingGame(int userId) throws IOException, SQLException {
        User user = new User();
        GameLogImpl gameLog = new GameLogImpl();
        System.out.println("Game Beginning!");
        SetCoins fc = new SetCoins();
        Random r = new Random();
        int coins = fc.findCoins(userId);
        /*
        number 1~100
         */
        //User input
        GetEnter getEnter = new GetEnter();
        while (coins >= 0){
            Scanner sr = new Scanner(System.in);
            System.out.println("*******Number Guessing Game*******");
            System.out.println("Please select the difficulty of the game");
            System.out.println("*******1.顶级难度！！*******");
            System.out.println("*******2.一般难度！！*******");
            System.out.println("*******3.简单难度！！*******");
            //Define Difficulty Variables n
            int n = 0;
            //Difficulty n represents the limit of the number of guesses
            if(sr.hasNextInt()){
                int hard = sr.nextInt();
                switch (hard){
                    case 1:
                        n = 2;
                        System.out.println("Please enter number from 1 to 100");
                        break;
                    case 2:
                        n = 5;
                        System.out.println("Please enter number from 1 to 100");
                        break;
                    case 3:
                        n = 7;
                        System.out.println("Please enter number from 1 to 100");
                        break;
                    default:
                        System.out.println("choose true digital!");
                        continue;
                }
            }
            int ranNumber = r.nextInt(100) + 1;
            //Test
            System.out.println("随机数为：" + ranNumber);
                //Set the initial guess count : i
                for(int i = 1; i <= n ; i++) {
                    //Determine whether the input number is reasonable
                    if(sr.hasNextInt()){
                        int guessNumber = sr.nextInt();
                        //guess success
                        if (guessNumber == ranNumber) {
                            //test i
                            System.out.println("Congrats on guessing! Your number of successes is" + i);
                            //different times different game coins
                            switch (i){
                                case 1:
                                    coins += 10;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+10);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+10 game coins");
                                    break;
                                case 2:
                                    coins += 8;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+8);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+8 game coins");
                                    break;
                                case 3:
                                    coins += 6;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+6);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+6 game coins");
                                    break;
                                case 4:
                                    coins += 4;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+4);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+4 game coins");
                                    break;
                                case 5:
                                    coins += 3;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+3);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+3 game coins");
                                    break;
                                case 6:
                                    coins += 1;
                                    gameLog.addGameLog("NumberGuessingGame",userId,+1);
                                    fc.updateCoins(coins,userId);
                                    System.out.println("+3 game coins");
                                    break;
                                case 7:
                                    gameLog.addGameLog("NumberGuessingGame",userId,0);
                                    System.out.println("7 times ,no game coins!");
                            }
                            //Let the player decide whether to continue playing
                            String c1 = "y";
                            String c2 = "n";
                            String choose = getEnter.getEnter("Whether to continue playing?\t" + c1 + "/" + c2);
                            if (choose.equals(c1)) {
                                break;
                            } else {
                                //back game choose
                                GameRun gameRun = new GameRun();
                                gameRun.run(user);
                            }
                            //guess bigger
                        } else if (guessNumber > ranNumber) {
                            //test i
                            System.out.println("次数为" + i);
                            System.out.println("Bigger");
                            //guess smaller
                        } else {
                            //test i
                            System.out.println("次数为" + i);
                            System.out.println("Smaller");
                        }
                        if (i == n) {
                            System.out.println("You are so unlucky that you didn't guess right"+ n +"times!");
                        }
                        System.out.println("Please note that you still have: " + (n - i) + " times, please enter carefully");


                //ineligible numbers
                }else {
                        System.out.println("Illegal characters entered, game over!");
                        System.out.println("Penalty: -5 game coins");
                        coins -= 5;
                        fc.updateCoins(coins,userId);
                        //Let the player decide whether to continue playing
                        String c1 = "y";
                        String c2 = "n";
                        String choose = getEnter.getEnter("Whether to continue playing?\t" + c1 + "/" + c2);
                        if (choose.equals(c1)) {
                            break;
                        } else {
                            //back game choose
                            GameRun gameRun = new GameRun();
                            gameRun.run(user);
                        }
                    }
                }


        }

    }

}
