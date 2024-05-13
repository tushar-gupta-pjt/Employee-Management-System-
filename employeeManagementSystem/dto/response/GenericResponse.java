package com.project.employeeManagementSystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {

    private HttpStatus httpStatus;

    private  String message;

    private T data;

    private Boolean error;


}
