package org.homework.pojo;

import java.util.HashSet;

/**
 * @author Jackie_chen
 * @title: User
 * @projectName RichManGame
 * @description: 用户类
 * @date 2022/1/1018:51
 */
public class User {
    private int userId;
    private int gameCoins;
    private String userName;
    private String passWord;
    public User(){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getGameCoins() {
        return gameCoins;
    }

    public void setGameCoins(int gameCoins) {
        this.gameCoins = gameCoins;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(int userId, int gameCoins, String userName, String passWord) {
        super();
        this.userId = userId;
        this.gameCoins = gameCoins;
        this.userName = userName;
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", cardID=" + gameCoins +
                ", userName='" + userName + '\'' +
                ", password='" + passWord + '\'' +
                '}';
    }
}
