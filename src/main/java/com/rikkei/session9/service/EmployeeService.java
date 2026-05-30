package com.rikkei.session9.service;

import com.rikkei.session9.model.dto.request.EmployeeCreateDTO;
import com.rikkei.session9.model.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeService {
    Employee createEmployee(EmployeeCreateDTO employeeCreateDTO);
    Employee uploadFile(Long id, MultipartFile file);
}
