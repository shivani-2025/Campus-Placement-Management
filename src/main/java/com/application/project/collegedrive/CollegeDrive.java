package com.application.project.collegedrive;

import com.application.project.Drive.Drive;
import com.application.project.college.College;
import jakarta.persistence.*;

@Entity
@Table(name = "collegedrive")
public class CollegeDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK → drive.id
    @ManyToOne
    @JoinColumn(name = "driveId", referencedColumnName = "id")
    private Drive drive;

    // FK → college.id
    @ManyToOne
    @JoinColumn(name = "collegeId", referencedColumnName = "id")
    private College college;

    // -------- Getters & Setters --------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}