package com.bridgelabz.employeepayrolljdbc;

import java.util.List;

public class EmployeePayrollMain {
    public static void main(String[] args) {

        EmployeePayrollService employeePayrollService = new EmployeePayrollService();

        // TO GET ALL EMPLOYEE DETAILS
        List<Employee> list = employeePayrollService.getAllEmployeeDetails();
        for (Employee person : list) {
            System.out.println(person);
        }

        // TO GET EMPLOYEE DETAILS USING ID
        System.out.println(employeePayrollService.getEmployeeDetailsById(2));

        //TO UPDATE EMPLOYEE SALARY USING PREPARED STATEMENT
        employeePayrollService.updateEmployeeSalary("TERISSA",50000.00);
    }
}
