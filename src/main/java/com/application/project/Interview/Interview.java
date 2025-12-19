package com.application.project.Interview;

import jakarta.persistence.*;   // ⭐ THIS WAS CRITICAL
import java.time.LocalDate;
import java.time.LocalTime;

import com.application.project.Employee.Employee;
import com.application.project.InterviewStatus.InterviewStatus;
import com.application.project.StudentDriveJob.StudentDriveJob;

@Entity
@Table(name = "interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FOREIGN KEY Many-to-One mapping
    @ManyToOne
    @JoinColumn(name = "studDriveJobId", referencedColumnName = "id")
    private StudentDriveJob studentDriveJob;

    // FOREIGN KEY Many-to-One mapping
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "currentRound")
    private Integer currentRound;

    // FOREIGN KEY Many-to-One mapping
    @ManyToOne
    @JoinColumn(name = "interviewStatusId", referencedColumnName = "id")
    private InterviewStatus interviewStatus;

    @Column(name = "interviewLink")
    private String interviewLink;

    @Column(name = "heLink")
    private String heLink;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "totalMarks")
    private Integer totalMarks;

    @Column(name = "totalPercentage")
    private Integer totalPercentage;

    // ===== getters & setters =====

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StudentDriveJob getStudentDriveJob() {
        return studentDriveJob;
    }

    public void setStudentDriveJob(StudentDriveJob studentDriveJob) {
        this.studentDriveJob = studentDriveJob;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(Integer currentRound) {
        this.currentRound = currentRound;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getInterviewLink() {
        return interviewLink;
    }

    public void setInterviewLink(String interviewLink) {
        this.interviewLink = interviewLink;
    }

    public String getHeLink() {
        return heLink;
    }

    public void setHeLink(String heLink) {
        this.heLink = heLink;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Integer totalMarks) {
        this.totalMarks = totalMarks;
    }

    public Integer getTotalPercentage() {
        return totalPercentage;
    }

    public void setTotalPercentage(Integer totalPercentage) {
        this.totalPercentage = totalPercentage;
    }
}
