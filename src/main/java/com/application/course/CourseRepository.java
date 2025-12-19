
package com.application.model.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository // 
public interface CourseRepository extends JpaRepository<Course, Integer> {

    // Spring Data JPA automatically provides methods like:
    // Course save(Course course);
    // Optional<Course> findById(Integer id);
    // List<Course> findAll();
    // void deleteById(Integer id);

    // --- Custom Query Methods (Optional) ---

    // Example: Find courses by their name (Spring generates the SQL query from the method name)
    // List<Course> findByCourseName(String courseName);

    // Example: Find courses where the name contains a specific string (case-insensitive)
    // List<Course> findByCourseNameContainingIgnoreCase(String partialName);
}