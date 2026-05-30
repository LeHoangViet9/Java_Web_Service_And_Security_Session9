package com.rikkei.session9.repository;

import com.rikkei.session9.model.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
