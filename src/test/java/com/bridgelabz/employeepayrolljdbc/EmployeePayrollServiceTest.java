package com.bridgelabz.employeepayrolljdbc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeePayrollServiceTest {

    @org.junit.jupiter.api.Test
    public void givenEmployeePayrollDataBase_whenRetrieved_shouldMatch_employeeCount() {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<Employee> employeeList = employeePayrollService.getAllEmployeeDetails();
        assertEquals(2, employeeList.size());
    }

    @org.junit.jupiter.api.Test
    public void givenNewSalaryForEmployee_whenUpdated_shouldReturn_updatedRowCount(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        int updatedRecord = employeePayrollService.updateEmployeeSalary("TERISSA",50000.00);
        assertEquals(1,updatedRecord);
    }

    @org.junit.jupiter.api.Test
    public void givenEmployeePayrollDataRange_whenRetrieved_shouldMatch_employeeCount(){
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        List<Employee> employeeList = employeePayrollService.retrieveEmployee("2018-06-01","2020-06-01");
        assertEquals(2, employeeList.size());
    }

}