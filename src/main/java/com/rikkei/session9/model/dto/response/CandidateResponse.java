package com.rikkei.session9.model.dto.response;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
@Builder
public class CandidateResponse {
    private Long id;
    private String name;
    private String email;
    private String cvUrl;
}
