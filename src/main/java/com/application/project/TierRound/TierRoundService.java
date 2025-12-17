package com.application.project.TierRound;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TierRoundService {

    private final TierRoundRepository repository;

    public TierRoundService(TierRoundRepository repository) {
        this.repository = repository;
    }

    public TierRound createTierRound(TierRound tierRound) {
        return repository.save(tierRound);
    }

    public List<TierRound> getAllTierRounds() {
        return repository.findAll();
    }

    public TierRound getTierRoundById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("TierRound not found with id: " + id));
    }

    public TierRound updateTierRound(Integer id, TierRound updated) {
        TierRound existing = getTierRoundById(id);
        existing.setTierTotalRound(updated.getTierTotalRound());
        existing.setDetailedRound(updated.getDetailedRound());
        return repository.save(existing);
    }

    public void deleteTierRound(Integer id) {
        repository.deleteById(id);
    }
}
