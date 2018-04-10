package com.training.audiomanager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(DatabaseConstants.DRIVER);
        return DriverManager.getConnection(DatabaseConstants.URL, DatabaseConstants.LOGIN, DatabaseConstants.PASSWORD);
    }
}
