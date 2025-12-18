package com.application.project.Drivejob;

import com.application.project.Drive.Drive;
import com.application.project.Drive.DriveRepository;
import com.application.project.Job.Job;
import com.application.project.Job.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriveJobService {

    @Autowired
    private DriveJobRepository driveJobRepository;

    @Autowired
    private DriveRepository driveRepository;

    @Autowired
    private JobRepository jobRepository;

    public DriveJob createDriveJob(DriveJob driveJob) {
        return driveJobRepository.save(driveJob);
    }

    public DriveJob getDriveJobById(Integer id) {
        return driveJobRepository.findById(id).orElse(null);
    }

    public List<DriveJob> getDriveJobsByDriveId(Integer driveId) {
        Optional<Drive> drive = driveRepository.findById(driveId);
        return drive.map(driveJobRepository::findByDrive)
                    .orElse(List.of());
    }

    public List<DriveJob> getDriveJobsByJobId(Integer jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        return job.map(driveJobRepository::findByJob)
                  .orElse(List.of());
    }

    public DriveJob updateDriveJob(Integer id, DriveJob driveJob) {

        Optional<DriveJob> existing = driveJobRepository.findById(id);

        if (existing.isPresent()) {
            DriveJob dj = existing.get();
            dj.setDrive(driveJob.getDrive());
            dj.setJob(driveJob.getJob());
            dj.setPackageValue(driveJob.getPackageValue());
            dj.setTenthCutOffPercentage(driveJob.getTenthCutOffPercentage());
            dj.setTwelfthCutOffPercentage(driveJob.getTwelfthCutOffPercentage());
            dj.setBacklogsEligibility(driveJob.getBacklogsEligibility());
            dj.setCgpaCutoff(driveJob.getCgpaCutoff());
            dj.setBranch(driveJob.getBranch());

            return driveJobRepository.save(dj);
        }
        return null;
    }

    public void deleteDriveJob(Integer id) {
        driveJobRepository.deleteById(id);
    }

    public List<DriveJob> getAllDriveJobs() {
        return driveJobRepository.findAll();
    }
}
