package com.application.project.collegedrive;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CollegeDriveService {

    private final CollegeDriveRepository repository;

    public CollegeDriveService(CollegeDriveRepository repository) {
        this.repository = repository;
    }

    public CollegeDrive create(CollegeDrive collegeDrive) {
        return repository.save(collegeDrive);
    }

    public List<CollegeDrive> getAll() {
        return repository.findAll();
    }

    public CollegeDrive getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("CollegeDrive not found with id: " + id));
    }

    public List<CollegeDrive> getByDriveId(Integer driveId) {
        return repository.findByDrive_Id(driveId);
    }

    public List<CollegeDrive> getByCollegeId(Integer collegeId) {
        return repository.findByCollege_Id(collegeId);
    }

    public CollegeDrive update(Integer id, CollegeDrive updated) {
        CollegeDrive existing = getById(id);

        existing.setDrive(updated.getDrive());
        existing.setCollege(updated.getCollege());

        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}