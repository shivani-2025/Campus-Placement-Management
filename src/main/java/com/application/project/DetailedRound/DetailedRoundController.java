package com.application.project.DetailedRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detailedrounds")
public class DetailedRoundController {

    @Autowired
    private DetailedRoundService service;

    // POST: Create a new DetailedRound
    @PostMapping
    public ResponseEntity<DetailedRound> createDetailedRound(@RequestBody DetailedRound detailedRound) {
        DetailedRound savedRound = service.save(detailedRound);
        return new ResponseEntity<>(savedRound, HttpStatus.CREATED); 
    }

    // GET: Retrieve all DetailedRounds
    @GetMapping
    public List<DetailedRound> getAllDetailedRounds() {
        return service.findAll();
    }

    // GET: Retrieve DetailedRound by ID
    @GetMapping("/{id}")
    public ResponseEntity<DetailedRound> getDetailedRoundById(@PathVariable Integer id) {
        Optional<DetailedRound> round = service.findById(id);
        return round.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // PUT: Update an existing DetailedRound
    @PutMapping("/{id}")
    public ResponseEntity<DetailedRound> updateDetailedRound(
        @PathVariable Integer id, 
        @RequestBody DetailedRound updatedRound) {
        
        DetailedRound result = service.updateDetailedRound(id, updatedRound);
        
        if (result != null) {
            return ResponseEntity.ok(result); // HTTP 200 OK
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
    
    // DELETE: Delete a DetailedRound by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetailedRound(@PathVariable Integer id) {
        Optional<DetailedRound> round = service.findById(id);
        if (round.isPresent()) {
            service.deleteById(id);
            return ResponseEntity.noContent().build(); // HTTP 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // HTTP 404 Not Found
        }
    }
}