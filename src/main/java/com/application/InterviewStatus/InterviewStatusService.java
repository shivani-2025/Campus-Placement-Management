package com.application.InterviewStatus;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InterviewStatusService {

    private final InterviewStatusRepository repo;

    public InterviewStatusService(InterviewStatusRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public InterviewStatus create(InterviewStatus status) {
        if (status.getStatus() == null || status.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status cannot be empty");
        }
        return repo.save(status);
    }

    // READ ALL
    public List<InterviewStatus> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public InterviewStatus getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("InterviewStatus not found"));
    }

    // UPDATE
    public InterviewStatus update(Integer id, InterviewStatus updatedStatus) {
        InterviewStatus existing = getById(id);

        if (updatedStatus.getStatus() == null || updatedStatus.getStatus().isBlank()) {
            throw new IllegalArgumentException("Status cannot be empty");
        }

        existing.setStatus(updatedStatus.getStatus());
        return repo.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        if (!repo.existsById(id)) {
            throw new RuntimeException("InterviewStatus not found");
        }
        repo.deleteById(id);
    }
}
