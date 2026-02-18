package com.application.project.Round;

import com.application.project.api.RApi;
import com.application.project.model.CreateRoundRequest;
import com.application.project.model.RoundView;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecruiterRoundController implements RApi {

    private final RecruiterRoundService recruiterRoundService;

    public RecruiterRoundController(RecruiterRoundService recruiterRoundService) {
        this.recruiterRoundService = recruiterRoundService;
    }

    //recruiter views all rounds
    @Override
    public ResponseEntity<List<RoundView>> getAllRoundss() {
        return ResponseEntity.ok(
                recruiterRoundService.getAllRounds()
        );
    }

    // recruiter creates a round
    @Override
    public ResponseEntity<RoundView> createeRound(
            CreateRoundRequest createRoundRequest) {

        return ResponseEntity.status(201).body(
                recruiterRoundService.createRound(createRoundRequest)
        );
    }

    // recruiter deletes a round
    @Override
    public ResponseEntity<Void> deleteeRound(Integer roundId) {
        recruiterRoundService.deleteRound(roundId);
        return ResponseEntity.noContent().build();
    }
}
