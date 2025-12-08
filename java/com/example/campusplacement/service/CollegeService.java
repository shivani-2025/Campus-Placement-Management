package com.example.campusplacement.service;

import com.example.campusplacement.dto.CollegeDTO;
import java.util.List;

public interface CollegeService {

    CollegeDTO addCollege(CollegeDTO dto);
    CollegeDTO getCollegeById(Long id);
    List<CollegeDTO> getAllColleges();
    CollegeDTO updateCollege(Long id, CollegeDTO dto);
    void deleteCollege(Long id);
}
