package com.example.campusplacement.repository;

import com.example.campusplacement.entity.PlacementOfficer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface PlacementOfficerRepository extends JpaRepository<PlacementOfficer, Long> {

    @Transactional
    @Modifying
    void deleteByCollegeId(Long collegeId);
}
