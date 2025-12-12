package com.application.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    // CREATE College
    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeService.createCollege(college);
    }

    // GET All Colleges
    @GetMapping
    public List<College> getAllColleges() {
        return collegeService.getAllColleges();
    }

    // GET College by ID
    @GetMapping("/{id}")
    public College getCollegeById(@PathVariable Integer id) {
        return collegeService.getCollegeById(id);
    }

    // UPDATE College
    @PutMapping("/{id}")
    public College updateCollege(@PathVariable Integer id, @RequestBody College college) {
        return collegeService.updateCollege(id, college);
    }

    // DELETE College (and delete its placement officers)
    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Integer id) {
        collegeService.deleteCollege(id);
        return "College deleted successfully!";
    }
}
