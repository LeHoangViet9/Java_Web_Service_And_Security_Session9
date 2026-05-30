package com.rikkei.session9.controller;

import com.rikkei.session9.model.dto.request.CandidateApplyDTO;
import com.rikkei.session9.model.dto.response.CandidateResponse;
import com.rikkei.session9.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/candidates")
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateService candidateService;
    @PostMapping("/apply")
    public CandidateResponse applyCandidate(@Valid @ModelAttribute CandidateApplyDTO candidateResponse){
        return  candidateService.apply(candidateResponse);
    }
}
