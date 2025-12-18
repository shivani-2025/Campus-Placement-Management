package com.application.project.PanelistAvailability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; // <--- 1. ADD THIS IMPORT

import java.util.List;
import java.util.Optional;

@Service
public class PanelistAvailabilityService {

    @Autowired
    private PanelistAvailabilityRepository repository;
    
    // 1. CREATE / UPDATE
    public PanelistAvailability save(PanelistAvailability availability) {
        // Validation or business logic goes here
        return repository.save(availability); 
    }

    // 2. READ ALL
    @Transactional(readOnly = true) // <--- 2. ADD THIS ANNOTATION
    public List<PanelistAvailability> findAll() {
        List<PanelistAvailability> availabilities = repository.findAll();

        // ----------------------------------------------------
        // *** FIX: FORCE LAZY LOADING FOR ALL ITEMS ***
        // ----------------------------------------------------
        for (PanelistAvailability record : availabilities) {
            if (record.getDrive() != null) {
                record.getDrive().getId(); // <--- 3. ADD THE INITIALIZATION CODE
            }
        }
        // ----------------------------------------------------
        
        return availabilities;
    }
    
    // 3. READ BY ID
    @Transactional(readOnly = true) // <--- 4. ADD THIS ANNOTATION
    public Optional<PanelistAvailability> findById(Long id) {
        Optional<PanelistAvailability> optionalAvailability = repository.findById(id); 

        // --------------------------------------------------------------------
        // *** FIX: FORCE LAZY LOADING FOR THE SINGLE ITEM ***
        // --------------------------------------------------------------------
        optionalAvailability.ifPresent(record -> {
            if (record.getDrive() != null) {
                record.getDrive().getId(); // <--- 5. ADD THE INITIALIZATION CODE
            }
        });
        // --------------------------------------------------------------------

        return optionalAvailability; 
    }
    
    // 4. DELETE
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}