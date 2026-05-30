package com.rikkei.session9.controller;

import com.rikkei.session9.model.dto.request.EmployeeCreateDTO;
import com.rikkei.session9.model.dto.response.ApiDataResponse;
import com.rikkei.session9.model.entity.Employee;
import com.rikkei.session9.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới nhân viên thành công",
                employeeService.createEmployee(employeeCreateDTO),
                null,
                HttpStatus.CREATED
        ),HttpStatus.CREATED);
    }

    @PutMapping("/{id}/avatar")
    public Employee uploadFile(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        return employeeService.uploadFile(id, file);
    }
}
