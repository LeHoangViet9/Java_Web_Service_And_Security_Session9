package com.rikkei.session9.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50,message = "Độ dài kí tự từ 5 đến 50")
    private String name;
    @Size(max = 100,message = "Độ dài tối đa là 100")
    private String description;
}
