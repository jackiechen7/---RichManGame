package org.homework.utils;

/**
 * @author Jackie_chen
 * @title: DbUtil
 * @projectName RichManGame
 * @description: TODO
 * @date 2022/1/1914:48
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @date 2019-12-9
 * @Description 连接数据库工具类
 * @author com.javayihao.top
 */
public class DbUtil {
    //把几个用于连接数据库的字符串定义成常量，不必每次去创建,这些字符串也可以通过配置文件方式读取
    private static final String USER = "root";//数据库用户名
    private static final String UPWD = "178512";//数据库密码
    //本地数据库shop
    private static final String URL = "jdbc:mysql://localhost:3306/RichManGame?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    //驱动
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //注册驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //得到数据库连接对象Connection的函数
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, UPWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭连接和 执行 的打开资源
    public static void close(Connection connection, Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //关闭所有的打开资源
    public static void close(Connection connection, Statement statement, ResultSet rs) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

