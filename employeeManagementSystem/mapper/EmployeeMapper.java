package com.project.employeeManagementSystem.mapper;

import com.project.employeeManagementSystem.dto.request.EmployeeRequest;
import com.project.employeeManagementSystem.model.Employee;

public class EmployeeMapper {

    public static Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest,Employee employee){
        employee.setName(employeeRequest.getName());
        employee.setPosition(employeeRequest.getPosition());
        employee.setSalary(employeeRequest.getSalary());

        return employee;
    }

}
