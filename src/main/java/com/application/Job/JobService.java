package com.application.Job;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;
    
    // 1. CREATE (Used by POST)
    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    // 2. READ ALL (Used by GET /api/jobs)
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // 3. READ BY ID (Used by GET /api/jobs/{id})
    public Job findJobById(Integer id) {
        // JpaRepository's findById returns an Optional, so we use orElse(null)
        return jobRepository.findById(id).orElse(null); 
    }

    // 4. UPDATE (Used by PUT /api/jobs/{id})
    public Job updateJob(Integer id, Job jobDetails) {
        // Find the existing Job by ID
        return jobRepository.findById(id)
            .map(existingJob -> {
                // Update the fields from the request body
                existingJob.setJobRole(jobDetails.getJobRole());
                existingJob.setTier(jobDetails.getTier());
                
                // Update the linked Employee.
                existingJob.setEmployee(jobDetails.getEmployee()); 
                
                // Save the updated entity back to the database
                return jobRepository.save(existingJob);
            })
            // If the job with the given ID is not found, return null
            .orElse(null); 
    }
    
    // 5. DELETE (Used by the new DELETE /api/jobs/{id})
    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }
}