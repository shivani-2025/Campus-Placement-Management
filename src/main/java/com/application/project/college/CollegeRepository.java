package com.application.project.college;

import com.application.project.tier.Tier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollegeRepository
        extends JpaRepository<College, Integer> {

    List<College> findByTier(Tier tier);
}
