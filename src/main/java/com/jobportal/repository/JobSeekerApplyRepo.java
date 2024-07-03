package com.jobportal.repository;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.entities.JobSeekerApply;
import com.jobportal.entities.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepo extends JpaRepository<JobSeekerApply, Integer> {

	List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

	List<JobSeekerApply> findByJob(JobPostActivity job);
}
