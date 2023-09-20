package com.newtech.employeeservice.service.impl;

import com.newtech.employeeservice.dto.ApiResponseDto;
import com.newtech.employeeservice.dto.DepartmentDto;
import com.newtech.employeeservice.dto.EmployeeDto;
import com.newtech.employeeservice.entity.Employee;
import com.newtech.employeeservice.exception.ErrorDetails;
import com.newtech.employeeservice.exception.ResourceNotFounfException;
import com.newtech.employeeservice.mapper.MyMapper;
import com.newtech.employeeservice.repo.EmployeeRepository;
import com.newtech.employeeservice.service.ApiDepartmentClient;
import com.newtech.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private MyMapper myMapper;
    private ApiDepartmentClient departmentClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = myMapper.toEmployee((employeeDto));
        Employee savedEmployee = employeeRepository.save(employee);
        return myMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public ApiResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFounfException("Employee not found: id = " + id)
        );
        EmployeeDto employeeDto=  myMapper.toEmployeeDto(employee);
        DepartmentDto departmentDto = departmentClient
                .getDepartmentByCode(employee.getDepartmentCode());

       return new ApiResponseDto(employeeDto, departmentDto);

    }

}
