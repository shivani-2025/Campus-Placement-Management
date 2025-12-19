
package com.application.model.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity // Marks this class as a JPA entity (table)
@Table(name = "course") // Specifies the name of the database table
public class Course {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Handles the AUTO_INCREMENT
    private Integer id; // Maps to INT PRIMARY KEY AUTO_INCREMENT

    @Column(name = "courseName", nullable = false, length = 50)
    private String courseName; // Maps to VARCHAR(50) NOT NULL

    // --- Constructors ---

    // Required by JPA specification
    public Course() {
    }

    // Constructor for easy object creation
    public Course(String courseName) {
        this.courseName = courseName;
    }

    // --- Getters and Setters ---

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Optional: toString() method for logging and debugging
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}