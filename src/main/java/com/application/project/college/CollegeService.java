package com.application.project.college;

import com.application.project.tier.Tier;
import com.application.project.tier.TierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private TierRepository tierRepository;

    public College createCollege(College college) {
        return collegeRepository.save(college);
    }

    public College getCollegeById(Integer id) {
        return collegeRepository.findById(id).orElse(null);
    }

    public List<College> getCollegesByTierId(Integer tierId) {
        Optional<Tier> tier = tierRepository.findById(tierId);
        return tier.map(collegeRepository::findByTier)
                   .orElse(List.of());
    }

    public College updateCollege(Integer id, College college) {

        Optional<College> existing = collegeRepository.findById(id);

        if (existing.isPresent()) {
            College c = existing.get();
            c.setName(college.getName());
            c.setLocation(college.getLocation());
            c.setTier(college.getTier());
            return collegeRepository.save(c);
        }
        return null;
    }

    public void deleteCollege(Integer id) {
        collegeRepository.deleteById(id);
    }

    public List<College> getAllColleges() {
        return collegeRepository.findAll();
    }
}
