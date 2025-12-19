package com.application.model.panelistdrive;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PanelistDriveService {

    private final PanelistDriveRepository repository;

    public PanelistDriveService(PanelistDriveRepository repository) {
        this.repository = repository;
    }

    public PanelistDrive create(PanelistDrive panelistDrive) {
        return repository.save(panelistDrive);
    }

    public List<PanelistDrive> getAll() {
        return repository.findAll();
    }

    public PanelistDrive getById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("PanelistDrive not found with id: " + id));
    }

    public PanelistDrive update(Integer id, PanelistDrive updated) {
        PanelistDrive existing = getById(id);

        existing.setDrive(updated.getDrive());
        existing.setPanelistHR(updated.getPanelistHR());
        existing.setPanelistTechnical(updated.getPanelistTechnical());
        existing.setPanelistG13(updated.getPanelistG13());

        return repository.save(existing);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}