package com.taoliu.final510.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author taoliu
 */
public class DBConnect {

    protected Connection connection;
    public Connection getConnection() {
        return connection;
    }


    static final String url = "jdbc:mysql://127.0.0.1:3306/510labs?autoReconnect=true&useSSL=false";
    static final String username = "root", password = "tonyliu123";


    public DBConnect() {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    }

}
