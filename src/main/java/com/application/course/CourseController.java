
package com.application.model.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/courses") // Base URL for all endpoints in this controller
public class CourseController {

    @Autowired // Inject the repository to interact with the database
    private CourseRepository courseRepository;

    /**
     * GET /api/courses
     * Retrieves all courses from the database.
     */
    @GetMapping
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    /**
     * GET /api/courses/{id}
     * Retrieves a single course by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Integer id) {
        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            return new ResponseEntity<>(course.get(), HttpStatus.OK); // HTTP 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // HTTP 404
        }
    }

    /**
     * POST /api/courses
     * Creates a new course.
     */
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            Course savedCourse = courseRepository.save(course);
            // Returns HTTP 201 (Created) and the newly created object
            return new ResponseEntity<>(savedCourse, HttpStatus.CREATED);
        } catch (Exception e) {
            // Returns HTTP 500 (Internal Server Error)
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * PUT /api/courses/{id}
     * Updates an existing course.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
            @PathVariable Integer id,
            @RequestBody Course updatedCourse) {

        Optional<Course> existingCourse = courseRepository.findById(id);

        if (existingCourse.isPresent()) {
            Course course = existingCourse.get();

            // Update fields (change according to your Course entity)
            course.setCourseName(updatedCourse.getCourseName());
            Course savedCourse = courseRepository.save(course);
            return new ResponseEntity<>(savedCourse, HttpStatus.OK); // 200
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
    }


    /**
     * DELETE /api/courses/{id}
     * Deletes a course by its ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Integer id) {
        try {
            courseRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // HTTP 204
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // HTTP 500
        }
    }

    // You can add a PUT/PATCH mapping for updating courses here as well
}