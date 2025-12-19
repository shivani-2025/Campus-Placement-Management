package com.application.model.StudentDriveJob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.model.StudentDriveJob.StudentDriveJob;

@Repository
public interface StudentDriveJobRepository extends JpaRepository<StudentDriveJob, Integer> {
}
