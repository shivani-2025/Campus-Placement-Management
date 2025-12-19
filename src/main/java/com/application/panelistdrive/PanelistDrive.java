package com.application.model.panelistdrive;

import com.application.model.Drive.Drive;
import jakarta.persistence.*;

@Entity
@Table(name = "panelistdrive")
public class PanelistDrive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ONLY FK
    @ManyToOne
    @JoinColumn(name = "driveId", referencedColumnName = "id")
    private Drive drive;

    // NORMAL INT COLUMNS (NOT FK)
    private Integer panelistHR;
    private Integer panelistTechnical;
    private Integer panelistG13;

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

    public Integer getPanelistHR() {
        return panelistHR;
    }

    public void setPanelistHR(Integer panelistHR) {
        this.panelistHR = panelistHR;
    }

    public Integer getPanelistTechnical() {
        return panelistTechnical;
    }

    public void setPanelistTechnical(Integer panelistTechnical) {
        this.panelistTechnical = panelistTechnical;
    }

    public Integer getPanelistG13() {
        return panelistG13;
    }

    public void setPanelistG13(Integer panelistG13) {
        this.panelistG13 = panelistG13;
    }
}