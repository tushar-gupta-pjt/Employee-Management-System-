package com.project.employeeManagementSystem.controller;

import com.project.employeeManagementSystem.dto.request.EmployeeRequest;
import com.project.employeeManagementSystem.dto.response.EmployeeResponse;
import com.project.employeeManagementSystem.dto.response.GenericResponse;
import com.project.employeeManagementSystem.exception.EmployeeNotFoundException;
import com.project.employeeManagementSystem.model.Employee;
import com.project.employeeManagementSystem.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.project.employeeManagementSystem.constant.EmployeeConstant.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {



    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<GenericResponse<?>> getAllEmployees(HttpServletRequest request) {
        try{
            log.info(String.format(SERVING_API, request.getRequestURL().toString()));
            List<Employee> response = employeeService.getAllEmployees();
            log.info(String.format(SERVED_API, request.getRequestURL().toString()));
            return  ResponseEntity.ok(new GenericResponse<>(HttpStatus.OK,EMPLOYEES_FETCHED_SUCCESSFULLY,response,false));
        } catch (Exception ex){
            log.error(String.format(ERROR_FETCHING_ALL_EMPLOYEES, ex.getMessage()));
            return new ResponseEntity<>(new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null, true), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<GenericResponse<?>> createEmployee(@RequestBody EmployeeRequest employeeRequest, HttpServletRequest request) {
        try{
            log.info(String.format(SERVING_API, request.getRequestURL().toString()));
            EmployeeResponse response  = employeeService.createEmployee(employeeRequest);
            log.info(String.format(SERVED_API, request.getRequestURL().toString()));
            return  ResponseEntity.ok(new GenericResponse<>(HttpStatus.CREATED,EMPLOYEE_ADDED_SUCCESSFULLY,response,false));
        }catch (Exception ex){
            log.error(String.format(ERROR_CREATING_EMPLOYEE, ex.getMessage()));
            return  new ResponseEntity<>(new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),null,true), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<?>> getEmployeeById(@PathVariable int id,HttpServletRequest request) {
        try{
            log.info(String.format(SERVING_API, request.getRequestURL().toString()));
            Employee response = employeeService.getEmployeeById(id);
            log.info(String.format(SERVED_API, request.getRequestURL().toString()));
            return  ResponseEntity.ok(new GenericResponse<>(HttpStatus.OK,EMPLOYEE_FETCHED_SUCCESSFULLY,response,false));
        }catch (EmployeeNotFoundException ex){
            log.error(String.format( ERROR_FETCHING_EMPLOYEE_BY_ID, ex.getMessage()));
            return  new ResponseEntity<>(new GenericResponse<>(HttpStatus.BAD_REQUEST,ex.getMessage(),null,true), HttpStatus.BAD_REQUEST);
        }catch (Exception ex){
            log.error(String.format( ERROR_FETCHING_EMPLOYEE_BY_ID, ex.getMessage()));
            return new ResponseEntity<>(new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null, true), HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @PutMapping("/{id}")
    public  ResponseEntity<GenericResponse<?>> updateEmployee(@PathVariable int id, @RequestBody EmployeeRequest employeeRequest,HttpServletRequest request){
        try{
            log.info(String.format(SERVING_API, request.getRequestURL().toString()));
            EmployeeResponse response = employeeService.updateEmployee(id,employeeRequest);
            log.info(String.format(SERVED_API, request.getRequestURL().toString()));
            return ResponseEntity.ok(new GenericResponse<>(HttpStatus.OK,EMPLOYEE_UPDATED_SUCCESSFULLY,response,false));
        }catch (EmployeeNotFoundException ex){
            log.error(String.format(ERROR_UPDATING_EMPLOYEE, ex.getMessage()));
            return  new ResponseEntity<>(new GenericResponse<>(HttpStatus.BAD_REQUEST,ex.getMessage(),null,true), HttpStatus.BAD_REQUEST);
        }catch (Exception ex){
            log.error(String.format(ERROR_UPDATING_EMPLOYEE, ex.getMessage()));
            return new ResponseEntity<>(new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null, true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponse<?>> deleteEmployee(@PathVariable int id,HttpServletRequest request){
        try{
            log.info(String.format(SERVING_API, request.getRequestURL().toString()));
            HashMap<String,Boolean> response = employeeService.deleteEmployee(id);
            log.info(String.format(SERVED_API, request.getRequestURL().toString()));
            return ResponseEntity.ok(new GenericResponse<>(HttpStatus.OK,EMPLOYEE_DELETED_SUCCESSFULLY,response,false));
        }catch (EmployeeNotFoundException ex){
            log.error(String.format(ERROR_DELETING_EMPLOYEE, ex.getMessage()));
            return  new ResponseEntity<>(new GenericResponse<>(HttpStatus.BAD_REQUEST,ex.getMessage(),null,true), HttpStatus.BAD_REQUEST);
        }catch (Exception ex){
            log.error(String.format(ERROR_DELETING_EMPLOYEE, ex.getMessage()));
            return new ResponseEntity<>(new GenericResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), null, true), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
