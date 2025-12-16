package com.application.InterviewRounds;

import com.application.DetailedRound.DetailedRound;
import com.application.Employee.Employee;
import com.application.InterviewStatus.InterviewStatus;
import com.application.TierRound.TierRound;

import jakarta.persistence.*;

@Entity
@Table(name = "interviewrounds")
public class InterviewRounds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // FK → studDriveJobId
    @ManyToOne
    @JoinColumn(name = "studDriveJobId", nullable = false)
    private DetailedRound studDriveJob;

    // FK → roundId (TierRound)
    @ManyToOne
    @JoinColumn(name = "roundId", nullable = false)
    private TierRound tierRound;

    private Integer totalScore;

    // FK → employeeId
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;

    private String feedback;

    // FK → interviewStatusId
    @ManyToOne
    @JoinColumn(name = "interviewStatusId", nullable = false)
    private InterviewStatus interviewStatus;

    private String detailedScore;
    private String techSkillsRecommendation;

    // ---------- getters & setters ----------

    public Integer getId() {
        return id;
    }

    public DetailedRound getStudDriveJob() {
        return studDriveJob;
    }

    public void setStudDriveJob(DetailedRound studDriveJob) {
        this.studDriveJob = studDriveJob;
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
