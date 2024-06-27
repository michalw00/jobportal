package com.jobportal.services;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.repository.JobPostActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostActivityService {
	private JobPostActivityRepo jobPostActivityRepo;

	@Autowired
	public JobPostActivityService(JobPostActivityRepo jobPostActivityRepo) {
		this.jobPostActivityRepo = jobPostActivityRepo;
	}

	public JobPostActivity addNew(JobPostActivity jobPostActivity) {
		return jobPostActivityRepo.save(jobPostActivity);
	}

}
