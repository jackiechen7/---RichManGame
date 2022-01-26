package org.homework.pojo;

import org.homework.test.GameRun;

import java.util.HashSet;

/**
 * @author Jackie_chen
 * @title: GameLog
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/209:15
 */
public class GameLog {
    private int id;
    private String gameName;
    private int coinsChanges;
    private int user_id;
    private String createTime;
    private HashSet<GameLog> set = new HashSet<GameLog>();

    public GameLog(){

    }

    public GameLog(int id, String gameName, int coinsChanges, int user_id, String createTime) {
        super();
        this.id = id;
        this.gameName = gameName;
        this.coinsChanges = coinsChanges;
        this.user_id = user_id;
        this.createTime = createTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getCoinsChanges() {
        return coinsChanges;
    }

    public void setCoinsChanges(int coinsChanges) {
        this.coinsChanges = coinsChanges;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GameLog{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", coinsChanges=" + coinsChanges +
                ", user_id=" + user_id +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
