package com.example.campusplacement.controller;

import com.example.campusplacement.dto.CollegeDTO;
import com.example.campusplacement.service.CollegeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/colleges")
public class CollegeController {

    private final CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping
    public List<CollegeDTO> getAllColleges() {
        return collegeService.getAllColleges();
    }

    @PostMapping
    public CollegeDTO addCollege(@RequestBody CollegeDTO dto) {
        return collegeService.addCollege(dto);
    }

    @GetMapping("/{id}")
    public CollegeDTO getCollegeById(@PathVariable Long id) {
        return collegeService.getCollegeById(id);
    }

    @PutMapping("/{id}")
    public CollegeDTO updateCollege(@PathVariable Long id, @RequestBody CollegeDTO dto) {
        return collegeService.updateCollege(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCollege(@PathVariable Long id) {
        collegeService.deleteCollege(id);
    }
}
