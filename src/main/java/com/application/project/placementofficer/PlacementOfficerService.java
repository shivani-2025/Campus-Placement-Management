package com.application.project.placementofficer;

import com.application.project.college.College;
import com.application.project.college.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementOfficerService {

    @Autowired
    private PlacementOfficerRepository poRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    public PlacementOfficer createPlacementOfficer(PlacementOfficer officer) {
        return poRepository.save(officer);
    }

    public PlacementOfficer getPlacementOfficerById(Integer id) {
        return poRepository.findById(id).orElse(null);
    }

    public List<PlacementOfficer> getPlacementOfficersByCollegeId(Integer collegeId) {
        Optional<College> college = collegeRepository.findById(collegeId);
        return college.map(poRepository::findByCollege)
                      .orElse(List.of());
    }

    public PlacementOfficer updatePlacementOfficer(Integer id, PlacementOfficer officer) {
        return poRepository.findById(id)
                .map(existing -> {
                    existing.setName(officer.getName());
                    existing.setPhoneNumber(officer.getPhoneNumber());
                    existing.setEmail(officer.getEmail());
                    existing.setCollege(officer.getCollege());
                    return poRepository.save(existing);
                })
                .orElse(null);
    }

    public void deletePlacementOfficer(Integer id) {
        poRepository.deleteById(id);
    }

    public List<PlacementOfficer> getAllPlacementOfficers() {
        return poRepository.findAll();
    }
}
