package com.application.project.Job;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobService {

    private final JobRepository repository;

    public JobService(JobRepository repository) {
        this.repository = repository;
    }

    public Job create(Job job) {
        return repository.save(job);
    }

    public List<Job> getAll() {
        return repository.findAll();
    }

    public Job getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    public Job update(Integer id, Job updated) {
        Job existing = getById(id);

        existing.setJobRole(updated.getJobRole());
        existing.setEmployee(updated.getEmployee());
        existing.setTier(updated.getTier());

        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
