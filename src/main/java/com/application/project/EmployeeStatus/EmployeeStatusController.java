package com.application.project.EmployeeStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empstatus")
public class EmployeeStatusController {

    private final EmployeeStatusService service;

    public EmployeeStatusController(EmployeeStatusService service) {
        this.service = service;
    }

    @GetMapping
    public List<EmployeeStatus> getAllStatuses() {
        return service.getAllStatuses();
    }

    @GetMapping("/{id}")
    public EmployeeStatus getStatus(@PathVariable Integer id) {
        return service.getStatusById(id);
    }

    @PostMapping
    public EmployeeStatus createStatus(@RequestBody EmployeeStatus status) {
        return service.saveStatus(status);
    }

    @PutMapping("/{id}")
    public EmployeeStatus updateStatus(@PathVariable Integer id, @RequestBody EmployeeStatus status) {
        status.setId(id);
        return service.saveStatus(status);
    }

    @DeleteMapping("/{id}")
    public String deleteStatus(@PathVariable Integer id) {
        service.deleteStatus(id);
        return "Status deleted";
    }
}
