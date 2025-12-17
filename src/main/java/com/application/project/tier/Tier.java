package com.application.project.tier;

import jakarta.persistence.*;

@Entity
@Table(
    name = "tier",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "tierNumber")
    }
)
public class Tier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private Integer tierNumber;

    // -------- Getters & Setters --------

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTierNumber() {
        return tierNumber;
    }

    public void setTierNumber(Integer tierNumber) {
        this.tierNumber = tierNumber;
    }
}
