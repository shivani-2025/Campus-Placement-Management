package com.application.project.TierTotalRound;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TierTotalRoundService {

    private final TierTotalRoundRepository repository;

    public TierTotalRoundService(TierTotalRoundRepository repository) {
        this.repository = repository;
    }

    public List<TierTotalRound> getAll() {
        return repository.findAll();
    }

    public TierTotalRound getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("TierTotalRound not found with id: " + id));
    }

    public TierTotalRound getByTierId(Integer tierId) {
        return repository.findByTier_Id(tierId)
                .orElseThrow(() ->
                        new RuntimeException("TierTotalRound not found for tierId: " + tierId));
    }

    public TierTotalRound save(TierTotalRound tierTotalRound) {
        return repository.save(tierTotalRound);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
