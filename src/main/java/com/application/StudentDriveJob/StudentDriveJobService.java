package com.application.model.StudentDriveJob;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.model.StudentDriveJob.StudentDriveJob;
import com.application.model.StudentDriveJob.StudentDriveJobRepository;

@Service
public class StudentDriveJobService {

    @Autowired
    private StudentDriveJobRepository repository;

    public StudentDriveJob save(StudentDriveJob studentDriveJob) {
        return repository.save(studentDriveJob);
    }

    public List<StudentDriveJob> getAll() {
        return repository.findAll();
    }

    public StudentDriveJob getById(int id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
