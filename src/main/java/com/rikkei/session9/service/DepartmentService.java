package com.rikkei.session9.service;

import com.rikkei.session9.model.dto.request.DepartmentDTO;
import com.rikkei.session9.model.entity.Department;

public interface DepartmentService {
    Department createDepartment(DepartmentDTO departmentDTO);
}
