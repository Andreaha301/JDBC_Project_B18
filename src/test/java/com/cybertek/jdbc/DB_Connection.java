package com.cybertek.jdbc;

import java.sql.*;

public class DB_Connection {

    public static void main(String[] args) throws SQLException {

        // CONNECTION --> STATEMENT --> RESULT TEST

        //Driver manager is used to get the connection
        // The IP address is the IP address of EC2 instance that have Oracle DataBase
        //This is known as connection string or URL
        //"jdbc:   making jdbc connection , always start with this
        //oracle: the database vendor (RDBMS) name we are trying to connect
        //thin: 1 type of oracle driver we are using ( downloaded using pom dependency)
        //@52.71.242.164: IP address of your database server
        //1521: port number of your database server ,  usually 1521 for oracle , 3306 for MySql Database
        //XE:  SID name  unique identifier for the database we are connecting
        // In a nutshell , see it as a full address of your database you can use to make connection
        String connectionStr = "jdbc:oracle:thin:@34.229.100.122:1521:XE";
        String username = "hr";
        String password = "hr";

        //JDBC ship with JDK, and has a lot of pre-written codes to work with database
        //everything we do below comes from java.sql package

        //Creating connection object using DriverManger's static method Connection
        Connection conn = DriverManager.getConnection(connectionStr, username, password) ;

        //Creating statement object using the connection we have established
        Statement stmnt = conn.createStatement();

        //ResulSet object is what we use to store the actual result we get from query
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS") ;


        System.out.println("THE END");


    }
}
