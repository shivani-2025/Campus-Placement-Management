package com.application.project.Drive;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "drive")
public class Drive {

    @Id
    private Integer id;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status;

    private Integer employeeIdCreatedBy;

    private Integer totalPanelistApply;

    private Integer driveTypeId;

    // --- GETTERS & SETTERS ---

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getEmployeeIdCreatedBy() {
        return employeeIdCreatedBy;
    }

    public void setEmployeeIdCreatedBy(Integer employeeIdCreatedBy) {
        this.employeeIdCreatedBy = employeeIdCreatedBy;
    }

    public Integer getTotalPanelistApply() {
        return totalPanelistApply;
    }

    public void setTotalPanelistApply(Integer totalPanelistApply) {
        this.totalPanelistApply = totalPanelistApply;
    }

    public Integer getDriveTypeId() {
        return driveTypeId;
    }

    public void setDriveTypeId(Integer driveTypeId) {
        this.driveTypeId = driveTypeId;
    }
}
