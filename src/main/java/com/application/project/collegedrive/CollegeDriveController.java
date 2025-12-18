package com.application.project.collegedrive;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/collegedrives")
public class CollegeDriveController {

    private final CollegeDriveService service;

    public CollegeDriveController(CollegeDriveService service) {
        this.service = service;
    }

    @PostMapping
    public CollegeDrive create(@RequestBody CollegeDrive collegeDrive) {
        return service.create(collegeDrive);
    }

    @GetMapping
    public List<CollegeDrive> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CollegeDrive getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @GetMapping("/drive/{driveId}")
    public List<CollegeDrive> getByDriveId(@PathVariable Integer driveId) {
        return service.getByDriveId(driveId);
    }

    @GetMapping("/college/{collegeId}")
    public List<CollegeDrive> getByCollegeId(@PathVariable Integer collegeId) {
        return service.getByCollegeId(collegeId);
    }

    @PutMapping("/{id}")
    public CollegeDrive update(
            @PathVariable Integer id,
            @RequestBody CollegeDrive collegeDrive) {
        return service.update(id, collegeDrive);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}