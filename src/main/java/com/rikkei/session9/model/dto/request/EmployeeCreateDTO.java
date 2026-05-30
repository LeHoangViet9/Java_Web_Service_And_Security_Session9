package com.rikkei.session9.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeCreateDTO {
    @NotBlank(message = "Không được để trống")
    private String fullName;
    @Email(message = "Email không đúng định dạng")
    @NotBlank(message = "Không được để trống")
    private String email;
    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "^(03|05|07|08|09)[0-9]{8}$",message = "Điện thoại không đúng định dạng")
    private String phone;
    @Min(value = 5000000,message = "Lương nhỏ nhất là 5000000")
    private Double salary;
    @NotNull(message = "Không được để trống")
    private Long departmentId;
}
