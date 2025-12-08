package com.example.campusplacement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.campusplacement.entity.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
}
