package com.application.InterviewRounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewRoundsService {

    @Autowired
    private InterviewRoundsRepository repository;

    // CREATE
    public InterviewRounds create(InterviewRounds interviewRounds) {
        return repository.save(interviewRounds);
    }

    // READ ALL
    public List<InterviewRounds> getAll() {
        return repository.findAll();
    }

    // READ BY ID
    public InterviewRounds getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("InterviewRounds not found"));
    }

    // UPDATE
    public InterviewRounds update(Integer id, InterviewRounds updated) {
        InterviewRounds existing = getById(id);

        existing.setStudDriveJob(updated.getStudDriveJob());
        existing.setTierRound(updated.getTierRound());
        existing.setTotalScore(updated.getTotalScore());
        existing.setEmployee(updated.getEmployee());
        existing.setFeedback(updated.getFeedback());
        existing.setInterviewStatus(updated.getInterviewStatus());
        existing.setDetailedScore(updated.getDetailedScore());
        existing.setTechSkillsRecommendation(updated.getTechSkillsRecommendation());

        return repository.save(existing);
    }

    // DELETE
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
