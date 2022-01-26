package org.homework;

import org.homework.test.SystemRun;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException {
        SystemRun systemRun = new SystemRun();
        systemRun.run();
    }
}
