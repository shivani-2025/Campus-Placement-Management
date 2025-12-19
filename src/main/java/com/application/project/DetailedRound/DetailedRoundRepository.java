package com.application.project.DetailedRound;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedRoundRepository extends JpaRepository<DetailedRound, Integer> {
    
    // Custom query to find the highest existing ID (required for manual generation)
    @Query("SELECT MAX(dr.id) FROM DetailedRound dr")
    Integer findMaxId();
    
}