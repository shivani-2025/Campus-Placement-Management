package com.application.project.collegedrive;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CollegeDriveRepository extends JpaRepository<CollegeDrive, Integer> {

    List<CollegeDrive> findByDrive_Id(Integer driveId);

    List<CollegeDrive> findByCollege_Id(Integer collegeId);
}