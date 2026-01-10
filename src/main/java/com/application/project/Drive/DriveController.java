package com.application.project.Drive;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drive")
public class DriveController {

    private final DriveService driveService;

    public DriveController(DriveService driveService) {
        this.driveService = driveService;
    }

    @PostMapping
    public Drive createDrive(@RequestBody Drive drive) {
        return driveService.createDrive(drive);
    }

    @GetMapping
    public List<Drive> getAllDrives() {
        return driveService.getAllDrives();
    }

    @GetMapping("/{id}")
    public Drive getDriveById(@PathVariable Integer id) {
        return driveService.getDriveById(id);
    }

    @PutMapping("/{id}")
    public Drive updateDrive(
            @PathVariable Integer id,
            @RequestBody Drive drive) {
        return driveService.updateDrive(id, drive);
    }

    @DeleteMapping("/{id}")
    public void deleteDrive(@PathVariable Integer id) {
        driveService.deleteDrive(id);
    }
}
