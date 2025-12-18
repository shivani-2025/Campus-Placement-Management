package com.application.project.Drivejob;

import com.application.project.Drive.Drive;
import com.application.project.Job.Job;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "drivejob")
public class DriveJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // ✅ FK → drive.id
    @ManyToOne
    @JoinColumn(name = "driveId", referencedColumnName = "id")
    private Drive drive;

    // ✅ FK → job.id
    @ManyToOne
    @JoinColumn(name = "jobId", referencedColumnName = "id")
    private Job job;

    @Column(name = "`package`")
    @JsonProperty("package")
    private String packageValue;

    private Integer tenthCutOffPercentage;
    private Integer twelfthCutOffPercentage;
    private Integer backlogsEligibility;
    private Integer cgpaCutoff;
    private String branch;

    public DriveJob() {}

    // ================= Getters & Setters =================

    public Integer getId() {
        return id;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPackageValue() {
        return packageValue;
    }

    public void setPackageValue(String packageValue) {
        this.packageValue = packageValue;
    }

    public Integer getTenthCutOffPercentage() {
        return tenthCutOffPercentage;
    }

    public void setTenthCutOffPercentage(Integer tenthCutOffPercentage) {
        this.tenthCutOffPercentage = tenthCutOffPercentage;
    }

    public Integer getTwelfthCutOffPercentage() {
        return twelfthCutOffPercentage;
    }

    public void setTwelfthCutOffPercentage(Integer twelfthCutOffPercentage) {
        this.twelfthCutOffPercentage = twelfthCutOffPercentage;
    }

    public Integer getBacklogsEligibility() {
        return backlogsEligibility;
    }

    public void setBacklogsEligibility(Integer backlogsEligibility) {
        this.backlogsEligibility = backlogsEligibility;
    }

    public Integer getCgpaCutoff() {
        return cgpaCutoff;
    }

    public void setCgpaCutoff(Integer cgpaCutoff) {
        this.cgpaCutoff = cgpaCutoff;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
