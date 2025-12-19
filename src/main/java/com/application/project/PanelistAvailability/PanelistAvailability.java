package com.application.project.PanelistAvailability;

import com.application.project.Drive.Drive;
import com.application.project.Employee.Employee;

import jakarta.persistence.*;
import java.time.LocalDate; // Correctly using LocalDate based on the DB screenshot

@Entity
@Table(name = "panelistavailability") // Confirmed table name
public class PanelistAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

 // Change both relationships from LAZY to EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId", nullable = false) 
    private Employee employee; 

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "driveId", nullable = false)
    private Drive drive;

    // --- Data Fields (Matching the Schema) ---
    @Column(name = "availableDate")
    private LocalDate availableDate; 
    
    @Column(name = "remarks")
    private String remarks;

    // Default Constructor (Required by JPA)
    public PanelistAvailability() {}

    // --- GETTERS & SETTERS ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public LocalDate getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(LocalDate availableDate) {
        this.availableDate = availableDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}