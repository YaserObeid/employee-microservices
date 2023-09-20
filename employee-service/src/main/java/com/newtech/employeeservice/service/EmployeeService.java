package com.newtech.employeeservice.service;

import com.newtech.employeeservice.dto.ApiResponseDto;
import com.newtech.employeeservice.dto.EmployeeDto;


public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    ApiResponseDto getEmployeeById(Long id);
}
