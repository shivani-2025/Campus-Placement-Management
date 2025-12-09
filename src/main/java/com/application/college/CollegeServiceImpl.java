package com.application.college;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.placementofficer.PlacementOfficerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeServiceImpl implements CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private PlacementOfficerRepository placementOfficerRepository;

    @Override
    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    @Override
    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }

    @Override
    public College getCollegeById(Integer id) {
        Optional<College> college = collegeRepository.findById(id);
        return college.orElse(null);
    }

    @Override
    public College updateCollege(Integer id, College college) {
        Optional<College> existing = collegeRepository.findById(id);

        if (existing.isPresent()) {
            College c = existing.get();

            // Update only existing fields
            c.setName(college.getName());
            c.setLocation(college.getLocation());
            c.setTier(college.getTier());

            return collegeRepository.save(c);
        }

        return null;
    }

    @Override
    public void deleteCollege(Integer id) {

        // Delete placement officers of this college
        placementOfficerRepository.deleteByCollegeId(id);

        // Delete the college
        collegeRepository.deleteById(id);
    }
}
