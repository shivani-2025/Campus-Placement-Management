package com.application.project.placementofficer;

import com.application.project.college.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlacementOfficerRepository
        extends JpaRepository<PlacementOfficer, Integer> {

    List<PlacementOfficer> findByCollege(College college);
}
