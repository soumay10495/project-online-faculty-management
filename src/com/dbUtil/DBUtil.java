package com.dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String url="jdbc:oracle:thin:@localhost:1521:XE";
    private static String username="system";
    private static String password="system";

    public static Connection getConnection() {
        Connection con = null;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(url,username,password);
        }
        catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return con;
    }

    public static void closeConnection(Connection con){
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
