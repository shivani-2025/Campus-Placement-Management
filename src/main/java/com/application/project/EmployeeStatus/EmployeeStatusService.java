package com.application.project.EmployeeStatus;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeStatusService {

    private final EmployeeStatusRepository repository;

    public EmployeeStatusService(EmployeeStatusRepository repository) {
        this.repository = repository;
    }

    public List<EmployeeStatus> getAllStatuses() {
        return repository.findAll();
    }

    public EmployeeStatus getStatusById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public EmployeeStatus saveStatus(EmployeeStatus status) {
        return repository.save(status);
    }

    public void deleteStatus(Integer id) {
        repository.deleteById(id);
    }
}
