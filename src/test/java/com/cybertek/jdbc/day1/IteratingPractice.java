package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingPractice {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@34.229.100.122:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password) ;
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES WHERE REGION_ID = 1") ;

        while (rs.next() == true ){

            System.out.println( rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME") + " " + rs.getInt(3));

        }




    }
}
