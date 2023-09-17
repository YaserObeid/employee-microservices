package com.newtech.employeeservice.service.impl;

import com.newtech.employeeservice.dto.EmployeeDto;
import com.newtech.employeeservice.entity.Employee;
import com.newtech.employeeservice.mapper.MyMapper;
import com.newtech.employeeservice.repo.EmployeeRepository;
import com.newtech.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private MyMapper myMapper;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = myMapper.toEmployee((employeeDto));
        Employee savedEmployee = employeeRepository.save(employee);
        return myMapper.toEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Resource not found: id = " + id)
        );
       return myMapper.toEmployeeDto(employee);
    }
}
