package com.rikkei.session9.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CandidateApplyDTO {
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotBlank(message = "Không được để trống")
    @Email(message = "Không đúng định dạng")
    private String email;
    private MultipartFile cvUrl;
}
