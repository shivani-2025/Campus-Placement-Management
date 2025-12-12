package com.application.placementofficer;

import java.util.List;

public interface PlacementOfficerService {

    PlacementOfficer createPlacementOfficer(PlacementOfficer officer);

    PlacementOfficer getPlacementOfficerById(Integer id);

    List<PlacementOfficer> getPlacementOfficersByCollegeId(Integer collegeId);

    PlacementOfficer updatePlacementOfficer(Integer id, PlacementOfficer officer);

    void deletePlacementOfficer(Integer id);

    List<PlacementOfficer> getAllPlacementOfficers();
}
