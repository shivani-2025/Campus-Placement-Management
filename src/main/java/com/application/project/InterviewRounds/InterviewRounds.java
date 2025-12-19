package com.application.project.InterviewRounds;

import jakarta.persistence.*;

import com.application.project.Employee.Employee;
import com.application.project.InterviewStatus.InterviewStatus;
import com.application.project.StudentDriveJob.StudentDriveJob;
import com.application.project.TierRound.TierRound;

@Entity
@Table(name = "interview_rounds")
public class InterviewRounds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK → student_drive_job.id
    @ManyToOne
    @JoinColumn(name = "studDriveJobId", referencedColumnName = "id")
    private StudentDriveJob studentDriveJob;

    // FK → tier_round.id  (roundId FK)
    @ManyToOne
    @JoinColumn(name = "roundId", referencedColumnName = "id")
    private TierRound tierRound;

    @Column(name = "totalScore")
    private Integer totalScore;

    // FK → employee.id
    @ManyToOne
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Employee employee;

    @Column(name = "feedback")
    private String feedback;

    // FK → interview_status.id
    @ManyToOne
    @JoinColumn(name = "interviewStatusId", referencedColumnName = "id")
    private InterviewStatus interviewStatus;

    @Column(name = "detailedScore")
    private String detailedScore;

    @Column(name = "techSkillsRecommendation")
    private String techSkillsRecommendation;

    // ===== Getters & Setters =====

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

    public TierRound getTierRound() {
        return tierRound;
    }

    public void setTierRound(TierRound tierRound) {
        this.tierRound = tierRound;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public InterviewStatus getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(InterviewStatus interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getDetailedScore() {
        return detailedScore;
    }

    public void setDetailedScore(String detailedScore) {
        this.detailedScore = detailedScore;
    }

    public String getTechSkillsRecommendation() {
        return techSkillsRecommendation;
    }

    public void setTechSkillsRecommendation(String techSkillsRecommendation) {
        this.techSkillsRecommendation = techSkillsRecommendation;
    }
}
