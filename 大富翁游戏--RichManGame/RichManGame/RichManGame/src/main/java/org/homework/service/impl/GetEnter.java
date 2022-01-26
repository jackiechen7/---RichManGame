package org.homework.service.impl;

import org.homework.service.getEnterDao;

import java.util.Scanner;

/**
 * @author Jackie_chen
 * @title: GetEnter
 * @projectName RichManGame
 * @description: 键盘输入函数
 * @date 2022/1/1021:44
 */
public class GetEnter implements getEnterDao {

    @Override
    public String getEnter(String name) {
        System.out.println("Please Enter" + name + ":");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
