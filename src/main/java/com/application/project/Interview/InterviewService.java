package com.application.project.Interview;
import org.springframework.stereotype.Service;

import com.application.project.TierTotalRound.TierTotalRound;
import com.application.project.TierTotalRound.TierTotalRoundRepository;

@Service
public class InterviewService {

    private final InterviewRepository interviewRepo;
    private final TierTotalRoundRepository tierRepo;

    public InterviewService(
            InterviewRepository interviewRepo,
            TierTotalRoundRepository tierRepo) {
        this.interviewRepo = interviewRepo;
        this.tierRepo = tierRepo;
    }

    public Interview save(Interview interview) {

        // Step 1: Student → College → Tier
        Student student =
                interview.getStudentDriveJob().getStudent();

        Integer tier =
                student.getCollege().getTier();

        // Step 2: Tier → totalRounds
        TierTotalRound tierTotalRound =
                tierRepo.findByTier(tier)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Tier not configured: " + tier));

        Integer totalRounds =
                tierTotalRound.getTotalRounds();

        // Step 3: Validate currentRound
        if (interview.getCurrentRound() == null ||
            interview.getCurrentRound() < 1) {
            throw new IllegalArgumentException(
                    "currentRound must be >= 1");
        }

        if (interview.getCurrentRound() > totalRounds) {
            throw new IllegalArgumentException(
                    "currentRound exceeds max rounds (" +
                    totalRounds + ") for tier " + tier);
        }

        return interviewRepo.save(interview);
    }

    public Interview findById(Integer id) {
        return interviewRepo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Interview not found"));
    }

    public void delete(Integer id) {
        interviewRepo.deleteById(id);
    }
}
