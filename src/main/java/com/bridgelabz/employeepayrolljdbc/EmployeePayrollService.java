package com.bridgelabz.employeepayrolljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeePayrollService {
    public static void main(String[] args) {

        //WELCOME TO EMPLOYEE PAYROLL SERVICE JDBC

        //UC1 - CREATE EMPLOYEE PAYROLL DATABASE AND CONNECT JAVA PROGRAM TO DATABASE
        try {
            //STEP 1: LOAD JDBC DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2 : ESTABLISH A CONNECTION TO DB
            String DB_URL = "jdbc:mysql://localhost:3306/employee_payroll_jdbc";
            Connection connection = DriverManager.getConnection(DB_URL, "root", "prem@1234567");

            //STEP 3 : EXECUTE SQL QUERY
            String CREATE_TABLE_QUERY = "create table employee_payroll(ID int NOT NULL AUTO_INCREMENT UNIQUE,NAME varchar(150) NOT NULL,GENDER char(1) NOT NULL,PHONE_NUMBER int NOT NULL,ADDRESS varchar(150) NOT NULL,DEPARTMENT varchar(50) NOT NULL,SALARY double NOT NULL,BASIC_PAY double NOT NULL,DEDUCTIONS double NOT NULL,NET_PAY double NOT NULL,START_DATE varchar(50) NOT NULL)";
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_QUERY);
            System.out.println("QUERY EXECUTED");

            //STEP 4 : CLOSE THE CONNECTION AND STATEMENT
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}

