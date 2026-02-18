package com.application.project.DriveStatus;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveStatusService {

    private final DriveStatusRepository driveStatusRepository;

    public DriveStatusService(DriveStatusRepository driveStatusRepository) {
        this.driveStatusRepository = driveStatusRepository;
    }

    public DriveStatus createDriveStatus(DriveStatus driveStatus) {
        return driveStatusRepository.save(driveStatus);
    }

    public List<DriveStatus> getAllDriveStatuses() {
        return driveStatusRepository.findAll();
    }

    public DriveStatus getDriveStatusById(Integer id) {
        return driveStatusRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("DriveStatus not found with id: " + id));
    }

    public DriveStatus updateDriveStatus(Integer id, DriveStatus updatedStatus) {

        DriveStatus existing = getDriveStatusById(id);
        existing.setStatusName(updatedStatus.getStatusName());

        return driveStatusRepository.save(existing);
    }

    public void deleteDriveStatus(Integer id) {
        driveStatusRepository.deleteById(id);
    }
}
