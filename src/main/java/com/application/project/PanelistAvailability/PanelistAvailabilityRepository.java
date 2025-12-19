package com.application.project.PanelistAvailability;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelistAvailabilityRepository extends JpaRepository<PanelistAvailability, Long> {
    
    // Spring automatically provides: save(), findAll(), findById(), deleteById(), etc.
    
}