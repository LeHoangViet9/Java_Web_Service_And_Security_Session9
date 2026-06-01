package com.rikkei.session9.controller;

import com.rikkei.session9.model.dto.request.DepartmentDTO;
import com.rikkei.session9.model.dto.response.ApiDataResponse;
import com.rikkei.session9.model.entity.Department;
import com.rikkei.session9.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<ApiDataResponse<Department>> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
            return new ResponseEntity<>(new ApiDataResponse<>(
                    "SUCCESS",
                    "Thêm mới phòng ban thành công",
                    departmentService.createDepartment(departmentDTO)
            ), HttpStatus.CREATED);
    }
}
