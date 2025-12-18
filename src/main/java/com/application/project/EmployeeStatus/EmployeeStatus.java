package com.application.project.EmployeeStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "employeestatus")
public class EmployeeStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "designation", length = 50)
    private String designation;

    public EmployeeStatus() {}

    public EmployeeStatus(Integer id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
