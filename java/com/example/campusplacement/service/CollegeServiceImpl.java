package com.example.campusplacement.service;

import com.example.campusplacement.dto.CollegeDTO;
import com.example.campusplacement.entity.College;
import com.example.campusplacement.mapper.CollegeMapper;
import com.example.campusplacement.repository.CollegeRepository;
import com.example.campusplacement.repository.PlacementOfficerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository collegeRepository;
    private final PlacementOfficerRepository placementOfficerRepository;

    public CollegeServiceImpl(CollegeRepository collegeRepository,
                              PlacementOfficerRepository placementOfficerRepository) {
        this.collegeRepository = collegeRepository;
        this.placementOfficerRepository = placementOfficerRepository;
    }

    @Override
    public CollegeDTO addCollege(CollegeDTO dto) {
        College college = CollegeMapper.toEntity(dto);
        return CollegeMapper.toDTO(collegeRepository.save(college));
    }

    @Override
    public CollegeDTO getCollegeById(Long id) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found"));
        return CollegeMapper.toDTO(college);
    }

    @Override
    public List<CollegeDTO> getAllColleges() {
        return collegeRepository.findAll()
                .stream()
                .map(CollegeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CollegeDTO updateCollege(Long id, CollegeDTO dto) {
        College college = collegeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("College not found"));

        college.setName(dto.getName());
        college.setLocation(dto.getLocation());
        college.setTier(dto.getTier()); // assuming College entity has tier field

        return CollegeMapper.toDTO(collegeRepository.save(college));
    }

    /**
     * Deletes a college along with all dependent placement officers.
     */
    @Override
    @Transactional
    public void deleteCollege(Long id) {
        // Step 1: Delete all placement officers linked to this college
        placementOfficerRepository.deleteByCollegeId(id);

        // Step 2: Delete the college itself
        collegeRepository.deleteById(id);
    }
}
