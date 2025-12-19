
package com.application.model.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Marks this class as a Spring Service component
public class CourseService {

    private final CourseRepository courseRepository;

    // Dependency Injection via Constructor is generally preferred over @Autowired on fields
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    /**
     * Retrieves all courses.
     * @return A list of all Course entities.
     */
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * Retrieves a single course by its ID.
     * @param id The ID of the course.
     * @return An Optional containing the Course if found, or empty if not.
     */
    public Optional<Course> findCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    /**
     * Creates or updates a course.
     * Uses @Transactional to ensure the operation is atomic.
     * @param course The Course object to save.
     * @return The saved Course object.
     */
    @Transactional
    public Course saveCourse(Course course) {
        // --- Business Logic goes here ---
        // Example: Validate courseName is not an empty string
        if (course.getCourseName() == null || course.getCourseName().trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be empty.");
        }

        // Example: Convert to uppercase before saving (Simple business rule)
        course.setCourseName(course.getCourseName().toUpperCase());

        return courseRepository.save(course);
    }

    /**
     * Deletes a course by its ID.
     * @param id The ID of the course to delete.
     * @return true if the course was found and deleted, false otherwise.
     */
    @Transactional
    public boolean deleteCourse(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Custom business method example: Checks if a course name already exists.
     */
    public boolean courseNameExists(String courseName) {
        // Assume you've added a custom method in CourseRepository:
        // Optional<Course> findByCourseName(String courseName);
        // return courseRepository.findByCourseName(courseName).isPresent();
        return false; // Placeholder for now
    }
}