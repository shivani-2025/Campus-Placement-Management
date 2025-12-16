package com.application.Interview;

import com.application.Employee.Employee;
import com.application.InterviewStatus.InterviewStatus;
import com.application.DetailedRound.DetailedRound;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 🔗 FK → StudDriveJob (assuming DetailedRound)
    @ManyToOne
    @JoinColumn(name = "studDriveJobId", nullable = false)
    private DetailedRound studDriveJob;

    // 🔗 FK → Employee (panelist)
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private Integer currentRound;

    // 🔗 FK → InterviewStatus
    @ManyToOne
    @JoinColumn(name = "interviewStatusId", nullable = false)
    private InterviewStatus interviewStatus;

    private String interviewLink;
    private String heLink;

    private LocalDate date;
    private LocalTime time;

    private Integer totalMarks;
    private Integer totalPercentage;

    // -------- getters & setters --------

    public Integer getId() {
        return id;
    }

    public DetailedRound getStudDriveJob() {
        return studDriveJob;
    }

    public void setStudDriveJob(DetailedRound studDriveJob) {
        this.studDriveJob = studDriveJob;
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
