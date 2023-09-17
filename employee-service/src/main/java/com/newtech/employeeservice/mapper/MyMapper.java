package com.newtech.employeeservice.mapper;

import com.newtech.employeeservice.dto.EmployeeDto;
import com.newtech.employeeservice.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
public interface  MyMapper {

    // map functions
    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);

}
