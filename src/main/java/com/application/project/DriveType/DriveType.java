package com.application.project.DriveType;

import jakarta.persistence.*;

@Entity
@Table(name = "drivetype")
public class DriveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String mode;

    public DriveType() {}

    public DriveType(Integer id, String mode) {
        this.id = id;
        this.mode = mode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}
