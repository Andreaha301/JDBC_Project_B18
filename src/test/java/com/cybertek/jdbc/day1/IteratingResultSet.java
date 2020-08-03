package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultSet {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@34.229.100.122:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password) ;
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS") ;

        // as long as rs.next() return true I know I have next row to print the data
        // we will keep looping as long as rs.next() return true

        while (rs.next() == true ){

            System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );

        }

/*
        rs.next(); // here we're in the first row USING table name
        System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );

        rs.next(); // here we're in the second row using index
        System.out.println( rs.getString(1) + " " + rs.getString(2) );

        rs.next(); // here we're in the third row USING table name
        System.out.println( rs.getString("REGION_ID") + " " + rs.getString("REGION_NAME") );

        rs.next(); // here we're in the forth row using index
        System.out.println( rs.getString(1) + " " + rs.getString(2) );

        //If we don't have more rows =, if we print rs.next() it will give ud "false"
        // As long as rs.next() return true, I know I have next row to print the data
        System.out.println( rs.next() );



 */

    }
}
