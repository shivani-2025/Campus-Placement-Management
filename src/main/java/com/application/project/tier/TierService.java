package com.application.project.tier;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TierService {

    private final TierRepository repository;

    public TierService(TierRepository repository) {
        this.repository = repository;
    }

    public Tier create(Tier tier) {
        return repository.save(tier);
    }

    public List<Tier> getAll() {
        return repository.findAll();
    }

    public Tier getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tier not found with id: " + id));
    }

    public Tier getByTierNumber(Integer tierNumber) {
        return repository.findByTierNumber(tierNumber)
                .orElseThrow(() -> new RuntimeException("Tier not found with tierNumber: " + tierNumber));
    }

    public Tier update(Integer id, Tier updated) {
        Tier existing = getById(id);
        existing.setTierNumber(updated.getTierNumber());
        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
