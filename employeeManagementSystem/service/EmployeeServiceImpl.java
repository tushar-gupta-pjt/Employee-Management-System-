package com.project.employeeManagementSystem.service;

import com.project.employeeManagementSystem.dto.request.EmployeeRequest;
import com.project.employeeManagementSystem.dto.response.EmployeeResponse;
import com.project.employeeManagementSystem.exception.EmployeeNotFoundException;
import com.project.employeeManagementSystem.mapper.EmployeeMapper;
import com.project.employeeManagementSystem.model.Employee;
import com.project.employeeManagementSystem.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import static com.project.employeeManagementSystem.constant.EmployeeConstant.*;

@Service
@Slf4j
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        log.info(String.format(FETCHING_ALL_EMPLOYEES));
        List<Employee> employees = employeeRepository.findAll();
        log.info(String.format(FETCHED_ALL_EMPLOYEES));
        return  employees;
    }

    @Override
    public Employee getEmployeeById(int id) {
        log.info(String.format(EMPLOYEE_FETCHING_BY_ID), id);
        return  employeeRepository.findById(id)
                    .orElseThrow(()-> new EmployeeNotFoundException(String.format( EMPLOYEE_NOT_FOUND_BY_ID, id)));

    }

    @Override
    @Transactional
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        log.info(String.format(EMPLOYEE_CREATING), employeeRequest);
        Employee employee = EmployeeMapper.mapEmployeeRequestToEmployee(employeeRequest,new Employee());
        employeeRepository.save(employee);
        log.info(String.format(EMPLOYEE_CREATED_SUCCESSFULLY), employee);
        return new EmployeeResponse(employee.getId());
    }

    @Override
    @Transactional
    public EmployeeResponse updateEmployee(int id, EmployeeRequest employeeRequest) {
        log.info(String.format(EMPLOYEE_UPDATING), id, employeeRequest);
        Employee employee = employeeRepository.findById(id)
                    .orElseThrow(()-> new EmployeeNotFoundException(String.format( EMPLOYEE_NOT_FOUND_BY_ID, id)));
        Employee updatedEmployee = EmployeeMapper.mapEmployeeRequestToEmployee(employeeRequest,employee);
        employeeRepository.save(updatedEmployee);
        log.info(String.format(EMPLOYEE_UPDATED_SUCCESSFULLY),updatedEmployee);
        return new EmployeeResponse(id);
    }

    @Override
    @Transactional
    public HashMap<String,Boolean> deleteEmployee(int id) {
        log.info(String.format(EMPLOYEE_DELETING), id);
        Employee toBeDeleted = employeeRepository.findById(id)
                    .orElseThrow(()-> new EmployeeNotFoundException(String.format( EMPLOYEE_NOT_FOUND_BY_ID, id)));
        employeeRepository.delete(toBeDeleted);
        log.info(String.format(EMPLOYEE_DELETED_SUCCESSFULLY), toBeDeleted);
        HashMap<String,Boolean> map = new HashMap<>();
        map.put(IS_DELETED, true);
        return map;
    }
}
