package com.newtech.departmentservice.controller;

import com.newtech.departmentservice.dto.DepartmentDto;
import com.newtech.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentRestController {

    private DepartmentService departmentService;

    //POST: /api/departments -> create department
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(
            @RequestBody DepartmentDto departmentDto){
        DepartmentDto department = departmentService
                .saveDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

    //GET: /api/departments/it001 -> department
    @GetMapping("{theCode}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(
                 @PathVariable("theCode") String departmentCode){
        DepartmentDto department = departmentService
                .getDepartmentByCode(departmentCode);

        return new ResponseEntity<>(department, HttpStatus.OK);

    }
}
