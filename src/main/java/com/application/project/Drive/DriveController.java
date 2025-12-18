package com.application.project.Drive;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drive")
public class DriveController {

    private final DriveService service;

    public DriveController(DriveService service) {
        this.service = service;
    }

    @GetMapping
    public List<Drive> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Drive getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public Drive create(@RequestBody Drive drive) {
        return service.create(drive);
    }

    @PutMapping("/{id}")
    public Drive update(@PathVariable Integer id, @RequestBody Drive drive) {
        return service.update(id, drive);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
