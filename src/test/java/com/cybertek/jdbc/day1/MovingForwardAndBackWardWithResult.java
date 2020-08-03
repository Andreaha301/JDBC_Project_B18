package com.cybertek.jdbc.day1;

import java.sql.*;

public class MovingForwardAndBackWardWithResult {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@34.229.100.122:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password) ;

        // if we create the Statement in this way , this will generate a forward only resultset
        // meaning we can only move forward with next() and can not move backward with previous
        //Statement stmnt = conn.createStatement();
        // ResultSet.TYPE_SCROLL_INSENSITIVE will make the resultset created from this statement
        // be able to move forward and backward ,
        // ResultSet.CONCUR_READ_ONLY  will make resultset readonly and that's what we need
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs = stmnt.executeQuery("SELECT * FROM COUNTRIES") ;

        rs.next(); // Row 1
        System.out.println( rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.next(); // Row 2
        System.out.println( rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));

        rs.previous(); // using previous, we go back to row 1, since we were in row 2
        System.out.println( rs.getString("COUNTRY_ID") + " " + rs.getString("COUNTRY_NAME"));






    }
}
