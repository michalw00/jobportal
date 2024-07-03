package com.jobportal.repository;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.entities.JobSeekerProfile;
import com.jobportal.entities.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepo extends JpaRepository<JobSeekerSave, Integer> {

	List<JobSeekerSave> findByUser(JobSeekerProfile user);

	List<JobSeekerSave> findByJob(JobPostActivity job);
}