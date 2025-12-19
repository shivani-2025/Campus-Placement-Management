package com.application.project.InterviewRounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.project.TierTotalRound.TierTotalRound;
import com.application.project.TierTotalRound.TierTotalRoundRepository;

import java.util.List;

@Service
public class InterviewRoundsService {

    @Autowired
    private InterviewRoundsRepository interviewRoundsRepository;

    @Autowired
    private TierTotalRoundRepository tierTotalRoundRepository;

    // CREATE (with max-round validation)
    public InterviewRounds save(InterviewRounds interviewRounds) {

        // student → college → tier
        Integer tier = interviewRounds
                .getStudentDriveJob()
                .getStudent()
                .getCollege()
                .getTier();

        // tier → totalRounds
        TierTotalRound tierTotalRound =
                tierTotalRoundRepository.findByTier(tier)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Tier not configured: " + tier));

        Integer maxRounds = tierTotalRound.getTotalRounds();

        // count existing rounds
        long existingRounds =
                interviewRoundsRepository.countByStudentDriveJob_Id(
                        interviewRounds.getStudentDriveJob().getId()
                );

        if (existingRounds >= maxRounds) {
            throw new RuntimeException(
                    "Maximum interview rounds (" + maxRounds +
                    ") already reached for this student"
            );
        }

        return interviewRoundsRepository.save(interviewRounds);
    }

    // READ ALL
    public List<InterviewRounds> findAll() {
        return interviewRoundsRepository.findAll();
    }

    // READ BY ID
    public InterviewRounds findById(Integer id) {
        return interviewRoundsRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Interview round not found"));
    }

    // READ HISTORY BY STUDENT
    public List<InterviewRounds> findByStudentDriveJob(Integer studDriveJobId) {
        return interviewRoundsRepository
                .findByStudentDriveJob_Id(studDriveJobId);
    }

    // DELETE
    public void delete(Integer id) {
        interviewRoundsRepository.deleteById(id);
    }
}
