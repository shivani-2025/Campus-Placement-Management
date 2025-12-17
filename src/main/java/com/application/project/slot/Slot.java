package com.application.project.slot;

import jakarta.persistence.*;
import java.time.LocalTime;

import com.application.project.Drive.Drive;

@Entity
@Table(name = "slot")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK → drive.id
    @ManyToOne
    @JoinColumn(name = "driveId", referencedColumnName = "id")
    private Drive drive;

    private LocalTime startTime;
    private LocalTime endTime;

    public Slot() {}

    // -------- Getters & Setters --------

    public Integer getId() {
        return id;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
