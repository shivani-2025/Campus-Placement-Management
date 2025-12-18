package com.application.project.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @PostMapping
    public College create(@RequestBody College college) {
        return collegeService.createCollege(college);
    }

    @GetMapping("/{id}")
    public College getById(@PathVariable Integer id) {
        return collegeService.getCollegeById(id);
    }

    @GetMapping("/tier/{tierId}")
    public List<College> getByTier(@PathVariable Integer tierId) {
        return collegeService.getCollegesByTierId(tierId);
    }

    @GetMapping
    public List<College> getAll() {
        return collegeService.getAllColleges();
    }

    @PutMapping("/{id}")
    public College update(
            @PathVariable Integer id,
            @RequestBody College college) {
        return collegeService.updateCollege(id, college);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        collegeService.deleteCollege(id);
    }
}
