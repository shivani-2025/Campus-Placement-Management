package com.application.Interview;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/interview")
public class InterviewController {

    private final InterviewService service;

    public InterviewController(InterviewService service) {
        this.service = service;
    }

    @PostMapping
    public Interview create(@RequestBody Interview interview) {
        return service.create(interview);
    }

    @GetMapping
    public List<Interview> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Interview getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Interview update(
            @PathVariable Integer id,
            @RequestBody Interview interview) {
        return service.update(id, interview);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
