package com.application.project.InterviewStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InterviewStatusRepository
        extends JpaRepository<InterviewStatus, Integer> {

    Optional<InterviewStatus> findByStatus(String status);
}
