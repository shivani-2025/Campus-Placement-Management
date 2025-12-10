package com.application.Drive;

import com.application.Employee.EmployeeRepository;
import com.application.DriveType.DriveTypeRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveService {

    private final DriveRepository driveRepo;
    private final EmployeeRepository employeeRepo;
    private final DriveTypeRepository driveTypeRepo;

    public DriveService(DriveRepository driveRepo,
                        EmployeeRepository employeeRepo,
                        DriveTypeRepository driveTypeRepo) {
        this.driveRepo = driveRepo;
        this.employeeRepo = employeeRepo;
        this.driveTypeRepo = driveTypeRepo;
    }

    // ------------------- CREATE -------------------
    public Drive create(Drive drive) {

        // 1️⃣ Check valid date range
        if (drive.getEndDate().isBefore(drive.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }

        // 2️⃣ Check employee exists
        if (!employeeRepo.existsById(drive.getEmployeeIdCreatedBy())) {
            throw new IllegalArgumentException("Invalid employeeIdCreatedBy. Employee does not exist.");
        }

        // 3️⃣ Check driveType exists
        if (!driveTypeRepo.existsById(drive.getDriveTypeId())) {
            throw new IllegalArgumentException("Invalid driveTypeId. Drive type does not exist.");
        }

        return driveRepo.save(drive);
    }

    // ------------------- READ -------------------
    public List<Drive> getAll() {
        return driveRepo.findAll();
    }

    public Drive getById(Integer id) {
        return driveRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Drive not found with id: " + id));
    }

    // ------------------- UPDATE -------------------
    public Drive update(Integer id, Drive updated) {
        Drive existing = getById(id);

        if (updated.getStartDate() != null)
            existing.setStartDate(updated.getStartDate());

        if (updated.getEndDate() != null)
            existing.setEndDate(updated.getEndDate());

        // Validate date order
        if (existing.getEndDate().isBefore(existing.getStartDate())) {
            throw new IllegalArgumentException("End date cannot be before start date.");
        }

        if (updated.getStatus() != null)
            existing.setStatus(updated.getStatus());

        if (updated.getEmployeeIdCreatedBy() != null) {
            if (!employeeRepo.existsById(updated.getEmployeeIdCreatedBy())) {
                throw new IllegalArgumentException("Employee does not exist.");
            }
            existing.setEmployeeIdCreatedBy(updated.getEmployeeIdCreatedBy());
        }

        if (updated.getTotalPanelistApply() != null)
            existing.setTotalPanelistApply(updated.getTotalPanelistApply());

        if (updated.getDriveTypeId() != null) {
            if (!driveTypeRepo.existsById(updated.getDriveTypeId())) {
                throw new IllegalArgumentException("Drive type does not exist.");
            }
            existing.setDriveTypeId(updated.getDriveTypeId());
        }

        return driveRepo.save(existing);
    }

    // ------------------- DELETE -------------------
    public void delete(Integer id) {
        driveRepo.deleteById(id);
    }
}
