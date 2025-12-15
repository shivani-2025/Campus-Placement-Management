package com.application.TierTotalRound;


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
        return repository.findById(id).orElse(null);
    }

    public TierTotalRound save(TierTotalRound tier) {
        return repository.save(tier);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
