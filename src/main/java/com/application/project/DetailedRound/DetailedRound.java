package com.application.project.DetailedRound;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "detailedround")
public class DetailedRound {

    @Id
    private Integer id; // ID is now set manually in the Service layer

    @Column(name = "roundName", nullable = false)
    private String roundName;

    // Default Constructor (Mandatory for JPA)
    public DetailedRound() {
    }

    // Constructor for creating new objects (optional, but useful)
    public DetailedRound(String roundName) {
        this.roundName = roundName;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    // Crucial: The setter for ID must be present
    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }
}