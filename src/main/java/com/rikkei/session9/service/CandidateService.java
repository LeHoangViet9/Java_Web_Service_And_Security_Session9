package com.rikkei.session9.service;

import com.rikkei.session9.model.dto.request.CandidateApplyDTO;
import com.rikkei.session9.model.dto.response.CandidateResponse;
import com.rikkei.session9.model.entity.Candidate;

public interface CandidateService {
    CandidateResponse apply(CandidateApplyDTO dto);
}
