package com.bridgelabz.employeepayrolljdbc;

import java.sql.*;

public class EmployeePayrollService {
    public static void main(String[] args) {

        //WELCOME TO EMPLOYEE PAYROLL SERVICE MYSQL JDBC

        //UC1 - CREATE EMPLOYEE PAYROLL DATABASE AND CONNECT JAVA PROGRAM TO DATABASE
        try {
            //STEP 1: LOAD JDBC DRIVER
            Class.forName("com.mysql.cj.jdbc.Driver");

            //STEP 2 : ESTABLISH A CONNECTION TO DB
            String DB_URL = "jdbc:mysql://localhost:3306/employee_payroll_jdbc";
            Connection connection = DriverManager.getConnection(DB_URL, "root", "prem@1234567");

            //STEP 3 : EXECUTE SQL QUERY
            String CREATE_TABLE_QUERY = "create table employee_payroll(ID int NOT NULL AUTO_INCREMENT UNIQUE,NAME varchar(150) NOT NULL,GENDER varchar(1) NOT NULL,PHONE_NUMBER int NOT NULL,ADDRESS varchar(150) NOT NULL,DEPARTMENT varchar(50) NOT NULL,SALARY double NOT NULL,BASIC_PAY double NOT NULL,DEDUCTIONS double NOT NULL,NET_PAY double NOT NULL,START_DATE varchar(50) NOT NULL)";
            String INSERT_QUERY = "insert into employee_payroll(ID,NAME,GENDER,PHONE_NUMBER,ADDRESS,DEPARTMENT,SALARY,BASIC_PAY,DEDUCTIONS,NET_PAY,START_DATE) values (1,'TERISSA','F',85965469,'GOA','SALES',10000.00,10000.00,2000.00,8000.00,'2020-06-01'),(2,'PREM','M',73875576,'NASHIK','HR',10000.00,10000.00,2000.00,8000.00,'2018-06-01')";

            //UC2 - RETRIEVE THE EMPLOYEE PAYROLL DATA FROM DATABASE
            String FETCH_RECORD_QUERY = "select * from employee_payroll ";

            //UC3 - UPDATE SALARY BASE PAY FOR EMPLOYEE TERISSA
            String UPDATE_RECORD_QUERY = "update employee_payroll set BASIC_PAY = 30000 where NAME = 'TERISSA'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(UPDATE_RECORD_QUERY);

            System.out.println("QUERY EXECUTED");

            //STEP 4 : CLOSE THE CONNECTION AND STATEMENT
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}