package com.application.placementofficer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacementOfficerServiceImpl implements PlacementOfficerService {

    @Autowired
    private PlacementOfficerRepository poRepository;

    @Override
    public PlacementOfficer createPlacementOfficer(PlacementOfficer officer) {
        return poRepository.save(officer);
    }

    @Override
    public PlacementOfficer getPlacementOfficerById(Integer id) {
        Optional<PlacementOfficer> officer = poRepository.findById(id);
        return officer.orElse(null);
    }

    @Override
    public List<PlacementOfficer> getPlacementOfficersByCollegeId(Integer collegeId) {
        return poRepository.findByCollegeId(collegeId);
    }

    @Override
    public PlacementOfficer updatePlacementOfficer(Integer id, PlacementOfficer officer) {
        Optional<PlacementOfficer> existing = poRepository.findById(id);

        if (existing.isPresent()) {
            PlacementOfficer p = existing.get();
            p.setName(officer.getName());
            p.setPhoneNumber(officer.getPhoneNumber());
            p.setEmail(officer.getEmail());
            p.setCollegeId(officer.getCollegeId());
            return poRepository.save(p);
        }

        return null;
    }

    @Override
    public void deletePlacementOfficer(Integer id) {
        poRepository.deleteById(id);
    }

    @Override
    public List<PlacementOfficer> getAllPlacementOfficers() {
        return poRepository.findAll();
    }
}
