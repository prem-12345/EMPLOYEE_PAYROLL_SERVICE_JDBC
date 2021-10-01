package com.bridgelabz.databaseconfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfiguration {
    private static Connection connection = null;

    static {
        String DB_URL = "jdbc:mysql://localhost:3306/employee_payroll_jdbc";
        String DB_USER = "root";
        String DB_PASSWORD = "prem@1234567";
        try {
            //STEP 1: LOAD JDBC DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2 : ESTABLISH A CONNECTION TO DB
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}