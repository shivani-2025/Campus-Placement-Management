package com.application.Job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs") 
public class JobController {

    @Autowired
    private JobService jobService; 

    // 1. CREATE: POST /api/jobs
    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job savedJob = jobService.saveJob(job);
        // Returns HTTP 201 Created
        return ResponseEntity.status(201).body(savedJob);
    }
    
    // 2. READ ALL: GET /api/jobs
    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        // Returns HTTP 200 OK
        return ResponseEntity.ok(jobs);
    }
    
    // 3. READ BY ID: GET /api/jobs/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Integer id) {
        Job job = jobService.findJobById(id); 

        if (job != null) {
            // Returns HTTP 200 OK
            return ResponseEntity.ok(job);
        } else {
            // Returns HTTP 404 Not Found
            return ResponseEntity.notFound().build(); 
        }
    }
    
    // 4. UPDATE: PUT /api/jobs/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable Integer id, @RequestBody Job jobDetails) {
        Job updatedJob = jobService.updateJob(id, jobDetails);

        if (updatedJob != null) {
            // Returns HTTP 200 OK
            return ResponseEntity.ok(updatedJob);
        } else {
            // Returns HTTP 404 Not Found if the ID does not exist
            return ResponseEntity.notFound().build();
        }
    }
    
    // 5. DELETE: DELETE /api/jobs/{id} <-- This completes the CRUD operations!
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Integer id) {
        jobService.deleteJob(id);
        // Returns HTTP 204 No Content for successful deletion
        return ResponseEntity.noContent().build();
    }
}