package com.application.project.placementofficer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/placementofficers")
public class PlacementOfficerController {

    @Autowired
    private PlacementOfficerService placementOfficerService;

    @PostMapping
    public PlacementOfficer create(@RequestBody PlacementOfficer officer) {
        return placementOfficerService.createPlacementOfficer(officer);
    }

    @GetMapping("/{id}")
    public PlacementOfficer getById(@PathVariable Integer id) {
        return placementOfficerService.getPlacementOfficerById(id);
    }

    @GetMapping("/college/{collegeId}")
    public List<PlacementOfficer> getByCollege(@PathVariable Integer collegeId) {
        return placementOfficerService.getPlacementOfficersByCollegeId(collegeId);
    }

    @GetMapping
    public List<PlacementOfficer> getAll() {
        return placementOfficerService.getAllPlacementOfficers();
    }

    @PutMapping("/{id}")
    public PlacementOfficer update(
            @PathVariable Integer id,
            @RequestBody PlacementOfficer officer) {
        return placementOfficerService.updatePlacementOfficer(id, officer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        placementOfficerService.deletePlacementOfficer(id);
    }
}
