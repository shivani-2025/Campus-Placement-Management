package com.application.project.InterviewRounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interview-rounds")
public class InterviewRoundsController {

    @Autowired
    private InterviewRoundsService service;

    @PostMapping
    public InterviewRounds create(@RequestBody InterviewRounds interviewRounds) {
        return service.save(interviewRounds);
    }

    @GetMapping
    public List<InterviewRounds> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public InterviewRounds getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @GetMapping("/student-drive-job/{id}")
    public List<InterviewRounds> getByStudentDriveJob(
            @PathVariable Integer id) {
        return service.findByStudentDriveJob(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
