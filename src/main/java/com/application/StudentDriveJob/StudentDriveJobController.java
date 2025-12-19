package com.application.model.StudentDriveJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.application.model.StudentDriveJob.StudentDriveJob;
import com.application.model.StudentDriveJob.StudentDriveJobService;

@RestController
@RequestMapping("/student-drive-jobs")
public class StudentDriveJobController {

    @Autowired
    private StudentDriveJobService service;

    @PostMapping
    public StudentDriveJob create(@RequestBody StudentDriveJob studentDriveJob) {
        return service.save(studentDriveJob);
    }

    @GetMapping
    public List<StudentDriveJob> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public StudentDriveJob getById(@PathVariable int id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Deleted successfully";
    }
}
