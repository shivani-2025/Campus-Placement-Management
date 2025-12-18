package com.application.project.DriveType;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DriveTypeService {

    private final DriveTypeRepository repo;

    public DriveTypeService(DriveTypeRepository repo) {
        this.repo = repo;
    }

    public List<DriveType> getAll() {
        return repo.findAll();
    }

    public DriveType getById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Drive type not found with id: " + id));
    }

    public DriveType create(DriveType driveType) {
        if (driveType.getMode() == null || driveType.getMode().isBlank()) {
            throw new IllegalArgumentException("Mode cannot be empty");
        }
        return repo.save(driveType);
    }

    public DriveType update(Integer id, DriveType updated) {
        DriveType existing = getById(id);

        if (updated.getMode() != null && !updated.getMode().isBlank()) {
            existing.setMode(updated.getMode());
        }

        return repo.save(existing);
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
