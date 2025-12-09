package com.application.placementofficer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementOfficerRepository extends JpaRepository<PlacementOfficer, Integer> {

    // Get placement officers by collegeId
    List<PlacementOfficer> findByCollegeId(Integer collegeId);

    // REQUIRED: Delete placement officers when a college is deleted
    void deleteByCollegeId(Integer collegeId);
}
