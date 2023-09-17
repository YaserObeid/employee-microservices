package com.newtech.employeeservice.controller;

import com.newtech.employeeservice.dto.EmployeeDto;
import com.newtech.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //POST: save an Employee /api/employees
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(
            @RequestBody EmployeeDto employeeDto){
        EmployeeDto employee = employeeService.saveEmployee(employeeDto);

        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    //POST: save an Employee /api/employees
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(
            @PathVariable Long id){
        EmployeeDto employee = employeeService.getEmployeeById(id);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


}
