package org.homework.dao.impl;

import org.homework.dao.loginDao;
import org.homework.pojo.User;
import org.homework.service.impl.GetEnter;
import org.homework.test.GameRun;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Jackie_chen
 * @title: MenuLogin
 * @projectName RichManGame
 * @description: 实现loginDao接口，用SearchUserByUserName类里的判断函数判断账户密码是否匹配
 * @date 2022/1/1021:35
 */
public class MenuLogin implements loginDao{
    @Override
    public void login() throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("RichMan System-->Login ");
            /*
            Enter user information
             */
//            System.out.print("Please enter UserName: ");
//            String username = sc.nextLine();
//            System.out.print("Please enter PassWord:  ");
//            String userPassword = sc.nextLine();
            GetEnter getEnter = new GetEnter();
            SearchUserByUserName sb = new SearchUserByUserName();
            String username = getEnter.getEnter(" UserName");
            String password = getEnter.getEnter(" Password");

            User user = sb.isLogin(username, password);
            /*
            If there is no account in the database, you will be prompted whether to register or not
             */
            if(sb.searchUserByName(username) == null){
                System.out.println("The account name you have entered is not registered. Do you want to register?");
                String c1 = "y";
                String c2 = "n";
                String choose = getEnter.getEnter(c1+"/"+c2);
                if(choose.equals(c1)){
                    MenuRegister menuRegister =new MenuRegister();
                    menuRegister.Register();
                    break;
                } else if (choose.equals(c2)){
                    System.out.println("Thanks! Will back to main page!");
                    break;
                } else {
                    break;
                }
            }
            /*
            Compare account and password
             */
            if(user != null) {
                // Jump to the game selection page
                System.out.println("Welcome to RichMan Game!");
                GameRun gameRun = new GameRun();
                //Returns the USER global variable
                gameRun.run(user);
                isEnd = true;
            } else {
                System.out.println("Login Fall! Will back to main page!");
            }


        }
    }
}
