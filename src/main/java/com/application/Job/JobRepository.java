package com.application.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    
    // Custom query method
    List<Job> findByTier(Integer tier);
}
