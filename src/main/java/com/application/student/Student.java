
package com.application.model.student; 

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDate;// Keep this import, but we'll only use @Column for one field

@Entity
@Table(name = "student")
public class Student {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
    
    @Column(nullable = false) 
    private Integer collegeID; 
    
    
    @Column(name="fullName")
    private String fullName;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    
    private Character gender;
    
    private Double cgpa; 
    
        @Column(name="resumeLink")
        private String resumeLink;
        
    @Column(name="email")
    private String email;
    
    @Column(name="phoneNumber")
    private String phoneNumber;
    
    private Integer rollNo;
    
    private Integer courseId;
    
    private String batch; // VARCHAR(20)
    
    private Integer streamId;
    
    // Maps to SQL DATE type
    private LocalDate dob;
    
    private Integer tenthPercent;
    
    private Integer tenthYearOfPassing;
    
    private Integer twelfthPercent;
    
    private Integer twelfthYearOfPassing;
    
    // Maps to INT DEFAULT 0
    private Integer currentBacklogs; 
    
   
    private String alternateEmail;
    
//    @Column(name = "alternatephone") 
    private String alternatePhone;
    
    public Student() {}
    
 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCollegeID() {
        return collegeID;
    }

    public void setCollegeID(Integer collegeID) {
        this.collegeID = collegeID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

 
    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Integer getRollNo() { 
    	return rollNo;
    	}
    public void setRollNo(Integer rollNo) { 
    	this.rollNo = rollNo; 
    	}

    public Integer getCourseId() {
    	return courseId;
    	}
    public void setCourseId(Integer courseId) {
    	this.courseId = courseId;
    	}

    public String getBatch() {
    	return batch; 
    	}
    public void setBatch(String batch) { 
    	this.batch = batch; 
    	}

    public Integer getStreamId() {
    	return streamId;
    	}
    public void setStreamId(Integer streamId) {
    	this.streamId = streamId; 
    	}

    public LocalDate getDob() {
    	return dob; 
    	}
    public void setDob(LocalDate dob) {
    	this.dob = dob; 
    	}

    public Integer getTenthPercent() { 
    	return tenthPercent; 
    	}
    public void setTenthPercent(Integer tenthPercent) {
    	this.tenthPercent = tenthPercent;
    	}

    public Integer getTenthYearOfPassing() {
    	return tenthYearOfPassing;
    	}
    public void setTenthYearOfPassing(Integer tenthYearOfPassing) { 
    	this.tenthYearOfPassing = tenthYearOfPassing; 
    	}

    public Integer getTwelfthPercent() {
    	return twelfthPercent;
    	}
    public void setTwelfthPercent(Integer twelfthPercent) { 
    	this.twelfthPercent = twelfthPercent; 
    	}

    public Integer getTwelfthYearOfPassing() {
    	return twelfthYearOfPassing; 
    	}
    public void setTwelfthYearOfPassing(Integer twelfthYearOfPassing) {
    	this.twelfthYearOfPassing = twelfthYearOfPassing;
    	}

    public Integer getCurrentBacklogs() {
    	return currentBacklogs; 
    	}
    public void setCurrentBacklogs(Integer currentBacklogs) {
    	this.currentBacklogs = currentBacklogs;
    	}

    public String getAlternateEmail() {
    	return alternateEmail;
    	}
    public void setAlternateEmail(String alternateEmail) { 
    	this.alternateEmail = alternateEmail; 
    	}

    public String getAlternatePhone() { 
    	return alternatePhone; 
    	}
    public void setAlternatePhone(String alternatePhone) {
    	this.alternatePhone = alternatePhone; 
    	}

    
    @Override
    public String toString() {
		return "Student [id=" + id + ", collegeID=" + collegeID + ", fullName=" + fullName + ", cgpa=" + cgpa + ",rollNo="+rollNo+",courseId="+courseId+",batch="+batch+",streamId="+streamId+",dob="+dob+",tenthPercent="+tenthPercent+",tenthYearOfPassing="+tenthYearOfPassing+",twelfthPercent="+twelfthPercent+",twelfthYearOfPassing="+twelfthYearOfPassing+",currentBacklogs="+currentBacklogs+",alternateEmail="+alternateEmail+",alternatePhone="+alternatePhone+"]";

    }
}