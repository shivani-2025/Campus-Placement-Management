package com.application.project.Drivejob;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivejobs")
public class DriveJobController {

    private final DriveJobService service;

    public DriveJobController(DriveJobService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<DriveJob>> getAll() {
        return ResponseEntity.ok(service.getAllDriveJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriveJob> getById(@PathVariable Integer id) {
        DriveJob job = service.getDriveJobById(id);
        return job != null
                ? ResponseEntity.ok(job)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DriveJob> create(@RequestBody DriveJob driveJob) {
        // ✅ NO setId() needed
        DriveJob created = service.createDriveJob(driveJob);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DriveJob> update(@PathVariable Integer id,
                                           @RequestBody DriveJob driveJob) {
        DriveJob updated = service.updateDriveJob(id, driveJob);
        return updated != null
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteDriveJob(id);
        return ResponseEntity.noContent().build();
    }
}
