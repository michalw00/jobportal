package com.jobportal.services;

import com.jobportal.entities.JobSeekerProfile;
import com.jobportal.repository.JobSeekerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerProfileService {
	private JobSeekerRepo jobSeekerRepo;

	@Autowired
	public JobSeekerProfileService(JobSeekerRepo jobSeekerRepo) {
		this.jobSeekerRepo = jobSeekerRepo;
	}

	public Optional<JobSeekerProfile> getOne(Integer id) {
		return jobSeekerRepo.findById(id);
	}

	public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
		return jobSeekerRepo.save(jobSeekerProfile);
	}
}
