package com.application.project.Drivejob;

import com.application.project.Drive.Drive;
import com.application.project.Job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriveJobRepository
        extends JpaRepository<DriveJob, Integer> {

    List<DriveJob> findByDrive(Drive drive);

    List<DriveJob> findByJob(Job job);
}
