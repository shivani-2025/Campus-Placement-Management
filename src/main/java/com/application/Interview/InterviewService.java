package com.application.Interview;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InterviewService {

    private final InterviewRepository repo;

    public InterviewService(InterviewRepository repo) {
        this.repo = repo;
    }

    // CREATE
    public Interview create(Interview interview) {

        if (interview.getTotalMarks() != null) {
            interview.setTotalPercentage(interview.getTotalMarks());
        }

        return repo.save(interview);
    }

    // READ ALL
    public List<Interview> getAll() {
        return repo.findAll();
    }

    // READ BY ID
    public Interview getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Interview not found"));
    }

    // UPDATE
    public Interview update(Integer id, Interview updated) {
        Interview existing = getById(id);

        existing.setCurrentRound(updated.getCurrentRound());
        existing.setInterviewStatus(updated.getInterviewStatus());
        existing.setInterviewLink(updated.getInterviewLink());
        existing.setHeLink(updated.getHeLink());
        existing.setDate(updated.getDate());
        existing.setTime(updated.getTime());
        existing.setTotalMarks(updated.getTotalMarks());
        existing.setTotalPercentage(updated.getTotalPercentage());

        return repo.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
