package com.application.project.Drive;

import com.application.project.Employee.Employee;
import com.application.project.Employee.EmployeeRepository;
import com.application.project.DriveStatus.DriveStatus;
import com.application.project.DriveStatus.DriveStatusRepository;
import com.application.project.DriveType.DriveType;
import com.application.project.DriveType.DriveTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriveService {

    private final DriveRepository driveRepository;
    private final EmployeeRepository employeeRepository;
    private final DriveTypeRepository driveTypeRepository;
    private final DriveStatusRepository driveStatusRepository;

    public DriveService(
            DriveRepository driveRepository,
            EmployeeRepository employeeRepository,
            DriveTypeRepository driveTypeRepository,
            DriveStatusRepository driveStatusRepository) {
        this.driveRepository = driveRepository;
        this.employeeRepository = employeeRepository;
        this.driveTypeRepository = driveTypeRepository;
        this.driveStatusRepository = driveStatusRepository;
    }

    public Drive createDrive(Drive drive) {

        if (drive.getEmployeeCreatedBy() != null) {
            Integer empId = drive.getEmployeeCreatedBy().getId();
            Employee employee = employeeRepository.findById(empId)
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
            drive.setEmployeeCreatedBy(employee);
        }

        if (drive.getDriveType() != null) {
            Integer typeId = drive.getDriveType().getId();
            DriveType driveType = driveTypeRepository.findById(typeId)
                    .orElseThrow(() -> new RuntimeException("DriveType not found with id: " + typeId));
            drive.setDriveType(driveType);
        }

        Integer statusId = drive.getDriveStatus().getId();
        DriveStatus status = driveStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("DriveStatus not found with id: " + statusId));
        drive.setDriveStatus(status);

        return driveRepository.save(drive);
    }

    public List<Drive> getAllDrives() {
        return driveRepository.findAll();
    }

    public Drive getDriveById(Integer id) {
        return driveRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Drive not found with id: " + id));
    }

    public Drive updateDrive(Integer id, Drive updatedDrive) {

        Drive existing = getDriveById(id);

        existing.setStartDate(updatedDrive.getStartDate());
        existing.setEndDate(updatedDrive.getEndDate());
        existing.setTotalPanelistApply(updatedDrive.getTotalPanelistApply());

        if (updatedDrive.getEmployeeCreatedBy() != null) {
            Integer empId = updatedDrive.getEmployeeCreatedBy().getId();
            Employee employee = employeeRepository.findById(empId)
                    .orElseThrow(() -> new RuntimeException("Employee not found with id: " + empId));
            existing.setEmployeeCreatedBy(employee);
        }

        if (updatedDrive.getDriveType() != null) {
            Integer typeId = updatedDrive.getDriveType().getId();
            DriveType driveType = driveTypeRepository.findById(typeId)
                    .orElseThrow(() -> new RuntimeException("DriveType not found with id: " + typeId));
            existing.setDriveType(driveType);
        }

        if (updatedDrive.getDriveStatus() != null) {
            Integer statusId = updatedDrive.getDriveStatus().getId();
            DriveStatus status = driveStatusRepository.findById(statusId)
                    .orElseThrow(() -> new RuntimeException("DriveStatus not found with id: " + statusId));
            existing.setDriveStatus(status);
        }

        return driveRepository.save(existing);
    }

    public void deleteDrive(Integer id) {
        driveRepository.deleteById(id);
    }
}
