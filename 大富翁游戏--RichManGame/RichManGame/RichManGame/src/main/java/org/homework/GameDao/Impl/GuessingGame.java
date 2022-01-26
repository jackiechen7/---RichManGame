package org.homework.GameDao.Impl;

import org.homework.GameDao.guessingGameDao;
import org.homework.pojo.User;
import org.homework.service.impl.GetEnter;
import org.homework.test.GameRun;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author Jackie_chen
 * @title: GuessingGame
 * @projectName RichManGame
 * @description: 一个猜拳游戏类，并且实时更新游戏币
 * @date 2022/1/1916:42
 */
public class GuessingGame implements guessingGameDao {

    @Override
    public void guessingGame(int userId) throws IOException, SQLException {
        User user = new User();
        SetCoins fc = new SetCoins();
        GameLogImpl gameLog = new GameLogImpl();
        int coins = fc.findCoins(userId);
        System.out.println(userId);
        /*
        0 rocks 1 scissors 2 paper
         */

        //User input
        GetEnter getEnter = new GetEnter();
        while (coins >= 0){
            System.out.println("*******Guessing Game*******");
            Random r = new Random();
            int fist = r.nextInt(3);
            System.out.println("0 means rock，1 means scissors, 2 means paper, and other keys returns to the main page");
            String sc = getEnter.getEnter(" ");
            if(sc.equals("0")){
                //player put rocks 0
                if(fist == 1){
                    System.out.println("Congrats you win! Coins + 2!:) :\tMe：rocks\t\tComputer：scissors");
                    coins += 2;
                    gameLog.addGameLog("GuessingGame",userId,+2);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else if(fist == 2){
                    System.out.println("Too bad the computer won:( Coins - 1:\tMe：rocks\t\tComputer：paper");
                    coins -= 1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);

                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else{
                    System.out.println("Draw! Coins - 1:\tMe：rocks\t\tComputer：rocks");
                    coins -=1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }
            }else if(sc.equals("1")) {
                //player put scissors 1
                if(fist == 0){
                    System.out.println("Too bad the computer won:( Coins - 1:\tMe：scissors\t\tComputer：rocks");
                    coins -= 1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else if(fist == 2){
                    System.out.println("Congrats you win! Coins + 2!:) :\tMe：Scissors\t\tComputer：paper");
                    coins += 2;
                    gameLog.addGameLog("GuessingGame",userId,+2);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else{
                    System.out.println("Draw! Coins - 1:\tMe：scissors\t\tComputer：scissors");
                    coins -=1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }
            }else if(sc.equals("2")) {
                //players put paper 2
                if(fist == 0){
                    System.out.println("Congrats you win! Coins + 2!:) :\tMe：paper\t\tComputer：rocks");
                    coins += 2;
                    gameLog.addGameLog("GuessingGame",userId,+2);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else if(fist == 1){
                    System.out.println("Too bad the computer won:( Coins - 1:\tMe：paper\t\tComputer：scissors");
                    coins -= 1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }else{
                    System.out.println("Draw! Coins - 1:\tMe：paper\t\tComputer：paper");
                    coins -= 1;
                    gameLog.addGameLog("GuessingGame",userId,-1);
                    fc.updateCoins(coins, userId);
                    System.out.println("Your current game coins is： " + coins);
                    if(coins < 0) {
                        System.out.println(" Sorry!You dont have anymore gameCoins\t" +
                                "Now go back to the upper list");
                        break;
                    }
                    continue;
                }
            }else {
                GameRun gameRun = new GameRun();
                gameRun.run(user);
            }

        }


    }
}
