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
        Connection connection = DataBaseConfiguration.getConnection();
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
}
