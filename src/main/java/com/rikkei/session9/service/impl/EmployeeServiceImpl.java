package com.rikkei.session9.service.impl;

import com.rikkei.session9.custom_validator.InvalidFileException;
import com.rikkei.session9.custom_validator.ResourceNotFoundException;
import com.rikkei.session9.model.dto.request.EmployeeCreateDTO;
import com.rikkei.session9.model.entity.Department;
import com.rikkei.session9.model.entity.Employee;
import com.rikkei.session9.repository.DepartmentRepository;
import com.rikkei.session9.repository.EmployeeRepository;
import com.rikkei.session9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    @Override
    public Employee createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        if(employeeRepository.existsByEmail(employeeCreateDTO.getEmail())) {
            throw new ResourceNotFoundException("Email đã tồn tại");
        }
        Department dp = departmentRepository
                .findById(employeeCreateDTO.getDepartmentId())
                .orElseThrow(() ->
                        new RuntimeException("Không tìm được phòng ban"));

        Employee em=Employee.builder()
                .fullName(employeeCreateDTO.getFullName())
                .email(employeeCreateDTO.getEmail())
                .phone(employeeCreateDTO.getPhone())
                .salary(employeeCreateDTO.getSalary())
                .department(dp)
                .build();
        return employeeRepository.save(em);
    }

    @Override
    public Employee uploadFile(Long id, MultipartFile file) {
        Employee em=employeeRepository.findById(id).orElseThrow(()-> new RuntimeException("Không tìm thấy nhân viên"));
        if(file==null||file.isEmpty()) {
            throw new RuntimeException("File không được để trống");
        }
        long maxSize=2*1024*1024;
        if(file.getSize() > maxSize) {
            throw new RuntimeException("File không được vượt quá 2MB");
        }
        String fileName=file.getOriginalFilename().toLowerCase();
        if (!(fileName.endsWith(".jpg")
                || fileName.endsWith(".jpeg")
                || fileName.endsWith(".png"))) {

            throw new RuntimeException("Chỉ chấp nhận jpg, jpeg, png");
        }
        try {
            String uploadDir="uploads/";
            File uploadDirFile=new File(uploadDir);
            if(!uploadDirFile.exists()){
                uploadDirFile.mkdirs();
            }
            String newFileName= UUID.randomUUID()+"_"+fileName;
            String filePath=uploadDir+newFileName;
            file.transferTo(new File(filePath));
            em.setAvatarUrl(filePath);
            return employeeRepository.save(em);
        }catch (Exception e) {
            throw new  RuntimeException("Upload file thất bại");
        }
    }
}
