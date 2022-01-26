package org.homework.test;

import org.homework.dao.impl.MenuLogin;
import org.homework.dao.impl.MenuRegister;
import org.homework.service.impl.MenuSelectImpl;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author Jackie_chen
 * @title: GameRun
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1018:27
 */
public class SystemRun {


    /**
     * run game
     */
    public void run() throws IOException, SQLException {
        while (true) {
            System.out.println("********************Welcome To RichMan Game********************");
            System.out.println("                          1、Register");
            System.out.println("                          2、Login");
            System.out.println("                          3、Out");
            System.out.println("                          4、Backend Management");
            System.out.println("**********************************************************");
            //Instantiate menu selection class
            MenuSelectImpl menuSelect = new MenuSelectImpl();
            int menuID = menuSelect.menuSelect();
            //Instantiate register class
            MenuRegister menuRegister = new MenuRegister();
            //Instantiate login class
            MenuLogin login = new MenuLogin();
            switch (menuID) {
                case 1 :
                    menuRegister.Register();
                    break;
                case 2 :
                    login.login();
                    break;
                case 3 :
                    System.exit(0);
                case 4 :
                    System.out.println("Backend Management");
                    break;



            }



        }
    }
}
