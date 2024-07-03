package com.jobportal.services;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.entities.JobSeekerProfile;
import com.jobportal.entities.JobSeekerSave;
import com.jobportal.repository.JobSeekerSaveRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSaveService {
	private final JobSeekerSaveRepo jobSeekerSaveRepo;

	public JobSeekerSaveService(JobSeekerSaveRepo jobSeekerSaveRepo) {
		this.jobSeekerSaveRepo = jobSeekerSaveRepo;
	}

	public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId) {
		return jobSeekerSaveRepo.findByUser(userAccountId);
	}

	public List<JobSeekerSave> getJobCandidate(JobPostActivity job) {
		return jobSeekerSaveRepo.findByJob(job);
	}

	public void addNew(JobSeekerSave jobSeekerSave) {
		jobSeekerSaveRepo.save(jobSeekerSave);
	}
}
