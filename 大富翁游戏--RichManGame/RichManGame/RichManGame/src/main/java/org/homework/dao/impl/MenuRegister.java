package org.homework.dao.impl;

import org.homework.dao.registerDao;
import org.homework.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Jackie_chen
 * @title: MenuRegister
 * @projectName RichManGame
 * @description: 写注册接口的具体实现方式，并且引用了SearchUserByUserName类来判断是否有重复名字
 * @date 2022/1/1020:31
 */
public class MenuRegister implements registerDao {
    @Override
    public void Register() {
        Scanner sc = new Scanner(System.in);
        /*
        Refer to the implementation of the SearchUserByUserName class to
        compare whether the userName is duplicated
         */
        SearchUserByUserName sb = new SearchUserByUserName();
        boolean isEnd = false;
        while (!isEnd) {
            System.out.println("RichMan System-->Register ");
            /*
            Enter user information
             */
            System.out.print("Please enter UserName: ");
           String newUsername = null;
           while (true) {
               newUsername = sc.nextLine();
               if(sb.searchUserByName(newUsername) == null){
                   break;
               }
               /*
               Not equal to NULL,
               indicating that there is a USER return,
               that is, there are duplicate names
                */
               System.out.println("Duplicate name, please re-enter！！！");
           }
            System.out.print("Please enter PassWord:  ");
            String newUserPassword = sc.nextLine();
            //Generate a random 6-digit user ID
            Random ran = new Random();
            int userid = ran.nextInt(899999) + 100000;
            //Generate gameCoins = 100
            int coins = 100;
            String sql = "insert into userinfo()values(?,?,?,?)";
            try {
                Connection con = DbUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, userid);
                pst.setInt(2, coins);
                pst.setString(3, newUsername);
                pst.setString(4, newUserPassword);
                //Returns false if the first result is an update count or if there is no result
                if(!pst.execute()) {
                    System.out.println("register success!");
                    isEnd = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("cannot insert" + e.getMessage());
            }

            //Encapsulate data with objects
//            User user = new User();
//            user.setUserName(newUsername);
//            user.setPassword(newUserPassword);
//            user.setUserId(userid);
//            user.setGameCoins(coins);

            //Create user action class object
//            UserDaoImplList newUid = new UserDaoImplList();

            //call the registration method
//            newUid.save(user);










        }

    }
}
