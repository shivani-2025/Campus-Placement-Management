package com.application.model.panelistdrive;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/panelist-drive")
public class PanelistDriveController {

    private final PanelistDriveService service;

    public PanelistDriveController(PanelistDriveService service) {
        this.service = service;
    }

    @PostMapping
    public PanelistDrive create(@RequestBody PanelistDrive panelistDrive) {
        return service.create(panelistDrive);
    }

    @GetMapping
    public List<PanelistDrive> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PanelistDrive getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public PanelistDrive update(
            @PathVariable Integer id,
            @RequestBody PanelistDrive panelistDrive) {
        return service.update(id, panelistDrive);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
