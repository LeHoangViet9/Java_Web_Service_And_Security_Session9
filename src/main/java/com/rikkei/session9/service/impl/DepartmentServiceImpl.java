package com.rikkei.session9.service.impl;

import com.rikkei.session9.model.dto.request.DepartmentDTO;
import com.rikkei.session9.model.entity.Department;
import com.rikkei.session9.repository.DepartmentRepository;
import com.rikkei.session9.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(DepartmentDTO departmentDTO) {
       Department dp=Department.builder()
               .name(departmentDTO.getName())
               .description(departmentDTO.getDescription())
               .build();
       return departmentRepository.save(dp);
    }
}
