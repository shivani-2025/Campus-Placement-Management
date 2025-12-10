package com.application.Job;

import com.application.Employee.Employee;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType; 

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "jobRole") // <-- FIX: Forces Hibernate to use "jobRole"
    private String jobRole;

    @ManyToOne 
    @JoinColumn(name = "employeeId", referencedColumnName = "id") // <-- Correctly uses "employeeId"
    private Employee employee; 

    @Column(name = "tier") // <-- FIX: Forces Hibernate to use "tier"
    private Integer tier;
    
    // --- CONSTRUCTORS ---
    public Job() {
    }

    public Job(Integer id, String jobRole, Employee employee, Integer tier) {
        this.id = id;
        this.jobRole = jobRole;
        this.employee = employee;
        this.tier = tier;
    }

    // --- GETTERS AND SETTERS ---
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }
}