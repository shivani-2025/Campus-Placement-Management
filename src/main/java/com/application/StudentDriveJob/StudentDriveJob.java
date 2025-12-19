package com.application.model.StudentDriveJob;

import com.application.model.drivejob.DriveJob;
import com.application.model.student.Student;

import jakarta.persistence.*;

@Entity
@Table(name = "studentdrivejob")
public class StudentDriveJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "driveJobId", referencedColumnName = "id")
    private DriveJob driveJob;

    @ManyToOne
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private Student student;

    // Constructors
    public StudentDriveJob() {}

    public StudentDriveJob(DriveJob driveJob, Student student) {
        this.driveJob = driveJob;
        this.student = student;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DriveJob getDriveJob() {
        return driveJob;
    }

    public void setDriveJob(DriveJob driveJob) {
        this.driveJob = driveJob;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}