package com.application.project.DriveStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drive-status")
public class DriveStatusController {

    private final DriveStatusService driveStatusService;

    public DriveStatusController(DriveStatusService driveStatusService) {
        this.driveStatusService = driveStatusService;
    }

    @PostMapping
    public DriveStatus createDriveStatus(@RequestBody DriveStatus driveStatus) {
        return driveStatusService.createDriveStatus(driveStatus);
    }

    @GetMapping
    public List<DriveStatus> getAllDriveStatuses() {
        return driveStatusService.getAllDriveStatuses();
    }

    @GetMapping("/{id}")
    public DriveStatus getDriveStatusById(@PathVariable Integer id) {
        return driveStatusService.getDriveStatusById(id);
    }

    @PutMapping("/{id}")
    public DriveStatus updateDriveStatus(
            @PathVariable Integer id,
            @RequestBody DriveStatus driveStatus) {
        return driveStatusService.updateDriveStatus(id, driveStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteDriveStatus(@PathVariable Integer id) {
        driveStatusService.deleteDriveStatus(id);
    }
}
