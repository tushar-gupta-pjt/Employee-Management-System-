/**
 * Service interface providing methods to interact with employees in the system.
 */
package com.project.employeeManagementSystem.service;

import com.project.employeeManagementSystem.dto.request.EmployeeRequest;
import com.project.employeeManagementSystem.dto.response.EmployeeResponse;
import com.project.employeeManagementSystem.model.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {

    /**
     * Retrieves all employees from the system.
     *
     * @return List of all employees.
     */
    List<Employee> getAllEmployees();

    /**
     * Retrieves an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return The employee with the specified ID.
     */
    Employee getEmployeeById(int id);

    /**
     * Creates a new employee in the system.
     *
     * @param employeeRequest The request containing the details of the employee to be created.
     * @return Response containing information about the created employee.
     */
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    /**
     * Updates an existing employee in the system.
     *
     * @param id              The ID of the employee to be updated.
     * @param employeeRequest The request containing the updated details of the employee.
     * @return Response containing information about the updated employee.
     */
    EmployeeResponse updateEmployee(int id, EmployeeRequest employeeRequest);

    /**
     * Deletes an employee from the system.
     *
     * @param id The ID of the employee to be deleted.
     * @return A HashMap containing a key-value pair indicating the success of the deletion operation.
     */
    HashMap<String, Boolean> deleteEmployee(int id);
}
