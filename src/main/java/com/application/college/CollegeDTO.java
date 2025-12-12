package com.application.college;

public class CollegeDTO {

    private Integer collegeId;
    private String name;
    private String location;
    private Integer tier;

    public Integer getCollegeId() { return collegeId; }
    public void setCollegeId(Integer collegeId) { this.collegeId = collegeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getTier() { return tier; }
    public void setTier(Integer tier) { this.tier = tier; }
}
