package com.bridgelabz.employeepayrolljdbc;

import com.bridgelabz.databaseconfiguration.DataBaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {

    //WELCOME TO EMPLOYEE PAYROLL SERVICE MYSQL JDBC

    Connection connection = DataBaseConfiguration.getConnection();
    PreparedStatement preparedStatement;

    public List<Employee> getAllEmployeeDetails() {
        String FETCH_RECORD_QUERY = "select * from employee_payroll ";
        Employee employee;
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(FETCH_RECORD_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("ID"));
                employee.setName(resultSet.getString("NAME"));
                employee.setGender(resultSet.getString("GENDER"));
                employee.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                employee.setAddress(resultSet.getString("ADDRESS"));
                employee.setDepartment(resultSet.getString("DEPARTMENT"));
                employee.setSalary(resultSet.getInt("SALARY"));
                employee.setBasicPay(resultSet.getInt("BASIC_PAY"));
                employee.setDeduction(resultSet.getInt("DEDUCTIONS"));
                employee.setNetPay(resultSet.getInt("NET_PAY"));
                employee.setStartDate(resultSet.getString("START_DATE"));
                employeeList.add(employee);
            }
            System.out.println("QUERY EXECUTED");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public Employee getEmployeeDetailsById(int id) {
        List<Employee> employeeList = getAllEmployeeDetails();
        Employee employee = employeeList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return employee;
    }

    public int updateEmployeeSalary(String NAME, double BASIC_PAY) {
        String UPDATE_RECORD_QUERY = "update employee_payroll set BASIC_PAY = ? where NAME = ? ";
        int row = 0;
        try {
            preparedStatement = connection.prepareStatement(UPDATE_RECORD_QUERY);
            preparedStatement.setDouble(1, BASIC_PAY);
            preparedStatement.setString(2, NAME);
            row = preparedStatement.executeUpdate();
            System.out.println("rows updated :" + row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public List<Employee> retrieveEmployee(String startDate, String endDate) {
        List<Employee> employeeList = new ArrayList<>();
        String SELECT_QUERY = "select * from employee_payroll where START_DATE between ? AND ?";
        String start = String.valueOf(startDate);
        String end = String.valueOf(endDate);
        Employee employee;
        try {
            preparedStatement = connection.prepareStatement(SELECT_QUERY);
            preparedStatement.setString(1, start);
            preparedStatement.setString(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setId(resultSet.getInt("ID"));
                employee.setName(resultSet.getString("NAME"));
                employee.setGender(resultSet.getString("GENDER"));
                employee.setPhoneNumber(resultSet.getInt("PHONE_NUMBER"));
                employee.setAddress(resultSet.getString("ADDRESS"));
                employee.setDepartment(resultSet.getString("DEPARTMENT"));
                employee.setSalary(resultSet.getInt("SALARY"));
                employee.setBasicPay(resultSet.getInt("BASIC_PAY"));
                employee.setDeduction(resultSet.getInt("DEDUCTIONS"));
                employee.setNetPay(resultSet.getInt("NET_PAY"));
                employee.setStartDate(resultSet.getString("START_DATE"));
                employeeList.add(employee);
            }
            for (Employee person : employeeList) {
                System.out.println(person);
            }
            System.out.println("QUERY EXECUTED");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    public void createTableEmployeeDetails() {
        String CREATE_TABLE_QUERY = "create table employee_details(ID int NOT NULL AUTO_INCREMENT UNIQUE,NAME varchar(150) NOT NULL,GENDER varchar(1) NOT NULL,PHONE_NUMBER int NOT NULL,ADDRESS varchar(150) NOT NULL,DEPARTMENT varchar(50) NOT NULL)";
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("QUERY EXECUTED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createTablePayrollDetails() {
        String CREATE_TABLE_QUERY = "create table payroll_details(EMP_ID int NOT NULL,SALARY double NOT NULL,BASIC_PAY double NOT NULL,DEDUCTIONS double NOT NULL,NET_PAY double NOT NULL)";
        try {
            preparedStatement = connection.prepareStatement(CREATE_TABLE_QUERY);
            preparedStatement.executeUpdate();
            System.out.println("QUERY EXECUTED");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
