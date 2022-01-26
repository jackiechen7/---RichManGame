package org.homework.service.impl;

import org.homework.service.MenuSelectDao;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Jackie_chen
 * @title: MenuSelectImpl
 * @projectName RichManGame
 * @description: 菜单选择函数
 * @date 2022/1/1019:35
 */
/*
  menu select class
 */
public class MenuSelectImpl implements MenuSelectDao {
    @Override
    public int menuSelect() {

        while (true) {
            try {
                System.out.println("Please enter your choice：");
                Scanner console = new Scanner(System.in);
                int menu = console.nextInt();
                if (menu == 1
                        || menu == 2
                        || menu == 3
                        || menu == 4) {
                    return menu;
                } else {
                    System.out.println("program done!");
                    System.exit(0);
                }

            } catch (InputMismatchException e) {
                System.out.println("please enter Integer！");
                continue;
            }

        }


    }
}
