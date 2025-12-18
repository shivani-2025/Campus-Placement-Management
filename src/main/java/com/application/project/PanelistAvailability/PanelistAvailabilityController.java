package com.application.project.PanelistAvailability;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/panelist-availability") // Base URL: http://localhost:9085/api/panelist-availability
public class PanelistAvailabilityController {

    @Autowired
    private PanelistAvailabilityService service;

    // 1. POST: Create a new Panelist Availability
    @PostMapping
    public ResponseEntity<PanelistAvailability> createAvailability(
            @RequestBody PanelistAvailability availability) {
        
        PanelistAvailability savedAvailability = service.save(availability);
        return new ResponseEntity<>(savedAvailability, HttpStatus.CREATED);
    }

    // 2. GET: Retrieve all Panelist Availabilities
    @GetMapping
    public ResponseEntity<List<PanelistAvailability>> getAllAvailabilities() {
        List<PanelistAvailability> availabilities = service.findAll();
        return ResponseEntity.ok(availabilities);
    }

    // 3. GET: Retrieve availability by ID
    @GetMapping("/{id}")
    public ResponseEntity<PanelistAvailability> getAvailabilityById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4. PUT: Update availability by ID (THIS WAS MISSING)
    @PutMapping("/{id}")
    public ResponseEntity<PanelistAvailability> updateAvailability(
            @PathVariable Long id, 
            @RequestBody PanelistAvailability availabilityDetails) {
        
        return service.findById(id).map(existingAvailability -> {
            // Update the existing record with new data from the request body
            existingAvailability.setEmployee(availabilityDetails.getEmployee());
            existingAvailability.setDrive(availabilityDetails.getDrive());
            existingAvailability.setAvailableDate(availabilityDetails.getAvailableDate());
            existingAvailability.setRemarks(availabilityDetails.getRemarks());
            
            PanelistAvailability updatedAvailability = service.save(existingAvailability);
            return ResponseEntity.ok(updatedAvailability);
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. DELETE: Delete availability by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.noContent().build(); 
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}