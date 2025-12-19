package com.application.model.panelistdrive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.application.model.panelistdrive.PanelistDrive;

@Repository
public interface PanelistDriveRepository extends JpaRepository<PanelistDrive, Integer> {
}
