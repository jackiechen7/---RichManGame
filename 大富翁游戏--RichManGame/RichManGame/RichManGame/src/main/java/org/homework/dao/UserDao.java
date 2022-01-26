package org.homework.dao;

import org.homework.pojo.User;

import java.util.List;

/**
 * @author Jackie_chen
 * @title: UserDao
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1018:36
 */
public interface UserDao {
    //User register
//    void save(User user);
    //User Update not
//    void update(User user);
//    User getById(int id);
//    List<User> getAll();
    /*
    username 账号
    password 密码
     */
    User isLogin(String userName, String passWord);




}
