package com.application.project.DriveType;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/drivetype")
public class DriveTypeController {

    private final DriveTypeService service;

    public DriveTypeController(DriveTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<DriveType> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public DriveType getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public DriveType create(@RequestBody DriveType driveType) {
        return service.create(driveType);
    }

    @PutMapping("/{id}")
    public DriveType update(@PathVariable Integer id, @RequestBody DriveType driveType) {
        return service.update(id, driveType);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
