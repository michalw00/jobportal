package com.jobportal.repository;

import com.jobportal.entities.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepo extends JpaRepository<JobSeekerProfile, Integer> {
}
