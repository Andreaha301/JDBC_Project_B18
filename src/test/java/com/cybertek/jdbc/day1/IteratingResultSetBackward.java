package com.cybertek.jdbc.day1;

import java.sql.*;

public class IteratingResultSetBackward {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@34.229.100.122:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password) ;
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS") ;

        //First move to the after last location
        // Then keep moving to previous row as long as there is more row above
        rs.afterLast();

        while ( rs.previous() == true){
            System.out.println( rs.getString(1) + " " + rs.getString(2));
        }

        System.out.println("---------- more moving ------------");

        //How to move to second row from here
        rs.absolute(2);
        System.out.println("currently I should be at 2nd row " + rs.getString(2));
        System.out.println( rs.getString(1) + " " + rs.getString(2));

        rs.first();
        System.out.println( rs.getString(1) + " " + rs.getString(2));

        rs.last();
        System.out.println( rs.getString(1) + " " + rs.getString(2));

        //How do I know which row number I'm right now at this location
        //getRow() method return the rwo number
        System.out.println( "rs.getRow() = " + rs.getRow());
        //There is no count method in ResultSet
        //so in order to get teh row







    }
}
