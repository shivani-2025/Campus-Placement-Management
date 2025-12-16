package com.application.InterviewRounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interviewrounds")
public class InterviewRoundsController {

    @Autowired
    private InterviewRoundsService service;

    // CREATE
    @PostMapping
    public InterviewRounds create(@RequestBody InterviewRounds interviewRounds) {
        return service.create(interviewRounds);
    }

    // READ ALL
    @GetMapping
    public List<InterviewRounds> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public InterviewRounds getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public InterviewRounds update(
            @PathVariable Integer id,
            @RequestBody InterviewRounds interviewRounds) {
        return service.update(id, interviewRounds);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
