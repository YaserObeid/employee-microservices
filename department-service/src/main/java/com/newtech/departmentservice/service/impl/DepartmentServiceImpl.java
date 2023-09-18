package com.newtech.departmentservice.service.impl;

import com.newtech.departmentservice.dto.DepartmentDto;
import com.newtech.departmentservice.entity.Department;
import com.newtech.departmentservice.exception.ResourceNotFoundException;
import com.newtech.departmentservice.repo.DepartmentRepository;
import com.newtech.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;
    private ModelMapper modelMapper;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = modelMapper
                .map(departmentDto, Department.class);
        return modelMapper.map(departmentRepository
                .save(department), departmentDto.getClass());
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

      Department department = departmentRepository
              .findByDepartmentCode(departmentCode);
      if(department == null)
          throw new ResourceNotFoundException(
                  "Department not found: departmentCode= "+ departmentCode);

        return modelMapper.map(department, DepartmentDto.class);
    }
}
