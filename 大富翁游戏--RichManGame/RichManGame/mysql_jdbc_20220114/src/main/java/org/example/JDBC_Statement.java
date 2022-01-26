package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class JDBC_Statement
{
    public static void main( String[] args ) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/demo?useSSL=false&useUnicode=true&characterEncoding=UTF-8&amp;serverTimezone=UTC";
        String username = "root";
        String password = "178512";
        Connection con = DriverManager.getConnection(url,username,password);
        System.out.println(con);

        String sql = "select * from info";
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Object id = resultSet.getObject("id");
        }
        resultSet.close();
        statement.close();
        con.close();

    }
}
