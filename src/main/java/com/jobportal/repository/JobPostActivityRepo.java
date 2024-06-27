package com.jobportal.repository;

import com.jobportal.entities.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostActivityRepo extends JpaRepository<JobPostActivity, Integer> {
}
