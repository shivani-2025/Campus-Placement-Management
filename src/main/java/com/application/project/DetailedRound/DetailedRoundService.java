package com.application.project.DetailedRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DetailedRoundService {

    @Autowired
    private DetailedRoundRepository repository;

    // --- POST/SAVE (Manual ID generation) ---
    @Transactional
    public DetailedRound save(DetailedRound detailedRound) {
        // 1. Find the current maximum ID
        Integer maxId = repository.findMaxId();
        
        // 2. Calculate the next available ID
        int nextId = (maxId == null) ? 1 : maxId + 1;
        
        // 3. Manually assign the ID to the entity object
        detailedRound.setId(nextId);
        
        // 4. Save the entity
        return repository.save(detailedRound);
    }
    
    // --- GET (Read All) ---
    public List<DetailedRound> findAll() {
        return repository.findAll();
    }
    
    // --- GET (Read One) ---
    public Optional<DetailedRound> findById(Integer id) {
        return repository.findById(id);
    }

    // --- PUT (Update) ---
    @Transactional
    public DetailedRound updateDetailedRound(Integer id, DetailedRound updatedRound) {
        
        return repository.findById(id).map(existingRound -> {
            
            // 1. Update the mutable fields (In this case, only roundName)
            existingRound.setRoundName(updatedRound.getRoundName());
            
            // 2. Save the managed entity
            return repository.save(existingRound); 
            
        }).orElse(null); // Return null if the ID is not found
    }

    // --- DELETE (Relies on Entity Cascade for child deletion) ---
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}