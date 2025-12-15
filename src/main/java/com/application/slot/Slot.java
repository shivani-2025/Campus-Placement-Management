package com.application.slot;


import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "slot")
public class Slot {

    @Id
    private Integer id;

    @Column(name = "driveId")
    private Integer driveId;

    private LocalTime startTime;
    private LocalTime endTime;

    public Slot() {}

    public Slot(Integer driveId, LocalTime startTime, LocalTime endTime) {
        this.driveId = driveId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDriveId() {
        return driveId;
    }

    public void setDriveId(Integer driveId) {
        this.driveId = driveId;
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

