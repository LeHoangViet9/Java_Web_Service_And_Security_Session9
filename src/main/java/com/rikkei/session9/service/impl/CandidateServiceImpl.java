package com.rikkei.session9.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.rikkei.session9.custom_validator.InvalidFileException;
import com.rikkei.session9.model.dto.request.CandidateApplyDTO;
import com.rikkei.session9.model.dto.response.CandidateResponse;
import com.rikkei.session9.model.entity.Candidate;
import com.rikkei.session9.repository.CandidateRepository;
import com.rikkei.session9.service.CandidateService;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Locale;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;
    private final Cloudinary cloudinary;


    @Override
    @Transactional
    public CandidateResponse apply(CandidateApplyDTO dto) {
        MultipartFile file=dto.getCvUrl();
        if(file==null){
            throw new InvalidFileException("File not existed");
        }
        String originFile=file.getOriginalFilename();
        if(originFile==null||!originFile.toLowerCase().endsWith(".pdf")){
            throw new  InvalidFileException("CV phải là pdf");
        }
        try {
            Map uploadFile=cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type","auto","folder","candidate_cv"));
            String url=uploadFile.get("secure_url").toString();
            Candidate candidate=Candidate.builder()
                    .name(dto.getName())
                    .email(dto.getEmail())
                    .cvUrl(url)
                    .build();
            Candidate saved=candidateRepository.save(candidate);
            return CandidateResponse.builder()
                    .id(saved.getId())
                    .name(saved.getName())
                    .email(saved.getEmail())
                    .cvUrl(saved.getCvUrl())
                    .build();
        }catch (Exception e){
            throw new RuntimeException("Upload CV thất bại");
        }
    }
}
