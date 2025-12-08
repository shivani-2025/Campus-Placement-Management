package com.example.campusplacement.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long collegeId;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "tier")
    private Integer tier;

    public College() {}

    public College(Long collegeId, String name, String location, Integer tier) {
        this.collegeId = collegeId;
        this.name = name;
        this.location = location;
        this.tier = tier;
    }

    public Long getCollegeId() { return collegeId; }
    public void setCollegeId(Long collegeId) { this.collegeId = collegeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getTier() { return tier; }
    public void setTier(Integer tier) { this.tier = tier; }
}
