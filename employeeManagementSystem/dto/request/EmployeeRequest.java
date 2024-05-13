package com.project.employeeManagementSystem.dto.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {


    private String name;

    private String position;

    private Double salary;
}
