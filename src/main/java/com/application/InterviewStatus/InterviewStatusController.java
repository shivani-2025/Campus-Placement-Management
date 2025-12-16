package com.application.InterviewStatus;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/interviewstatus")
public class InterviewStatusController {

    private final InterviewStatusService service;

    public InterviewStatusController(InterviewStatusService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public InterviewStatus create(@RequestBody InterviewStatus status) {
        return service.create(status);
    }

    // READ ALL
    @GetMapping
    public List<InterviewStatus> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public InterviewStatus getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public InterviewStatus update(
            @PathVariable Integer id,
            @RequestBody InterviewStatus status) {
        return service.update(id, status);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
