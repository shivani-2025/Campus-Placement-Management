package com.application.project.Drive;

import com.application.project.Employee.Employee;
import com.application.project.DriveStatus.DriveStatus;
import com.application.project.DriveType.DriveType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "drive")
public class Drive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Integer totalPanelistApply;

    @ManyToOne
    @JoinColumn(name = "employeeIdCreatedBy")
    private Employee employeeCreatedBy;

    @ManyToOne
    @JoinColumn(name = "driveTypeId")
    private DriveType driveType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "driveStatusId", nullable = false)
    private DriveStatus driveStatus;

    public Drive() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalPanelistApply() {
        return totalPanelistApply;
    }

    public void setTotalPanelistApply(Integer totalPanelistApply) {
        this.totalPanelistApply = totalPanelistApply;
    }

    public Employee getEmployeeCreatedBy() {
        return employeeCreatedBy;
    }

    public void setEmployeeCreatedBy(Employee employeeCreatedBy) {
        this.employeeCreatedBy = employeeCreatedBy;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public DriveStatus getDriveStatus() {
        return driveStatus;
    }

    public void setDriveStatus(DriveStatus driveStatus) {
        this.driveStatus = driveStatus;
    }
}
