package com.bushanskiy.springapplication.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnUtils {

    public static Connection getOracleConnection()
            throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String sid = "xe";
        String userName = "example";
        String password = "example";

        return getOracleConnection(hostName, sid, userName, password);
    }

    private static Connection getOracleConnection(String hostName, String sid,
                                                  String userName, String password) throws ClassNotFoundException,
            SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // Example: jdbc:oracle:thin:@localhost:1521:db11g
        String connectionURL = "jdbc:oracle:thin:@" + hostName + ":1521:" + sid;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}