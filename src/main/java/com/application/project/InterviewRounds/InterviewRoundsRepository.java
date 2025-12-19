package com.application.project.InterviewRounds;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InterviewRoundsRepository
        extends JpaRepository<InterviewRounds, Integer> {

    long countByStudentDriveJob_Id(Integer studDriveJobId);

    List<InterviewRounds> findByStudentDriveJob_Id(Integer studDriveJobId);
}
