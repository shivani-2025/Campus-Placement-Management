package com.application.project.Job;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {

    private final JobService service;

    public JobController(JobService service) {
        this.service = service;
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return service.create(job);
    }

    @GetMapping
    public List<Job> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Job getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Job update(
            @PathVariable Integer id,
            @RequestBody Job job) {
        return service.update(id, job);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
