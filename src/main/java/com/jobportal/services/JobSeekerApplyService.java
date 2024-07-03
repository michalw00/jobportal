package com.jobportal.services;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.entities.JobSeekerApply;
import com.jobportal.entities.JobSeekerProfile;
import com.jobportal.repository.JobSeekerApplyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerApplyService {
	private JobSeekerApplyRepo jobSeekerApplyRepo;

	@Autowired
	public JobSeekerApplyService(JobSeekerApplyRepo jobSeekerApplyRepo) {
		this.jobSeekerApplyRepo = jobSeekerApplyRepo;
	}

	public List<JobSeekerApply> getCandidatesJobs(JobSeekerProfile userAccountId) {
		return jobSeekerApplyRepo.findByUserId(userAccountId);
	}

	public List<JobSeekerApply> getJobCandidates(JobPostActivity job) {
		return jobSeekerApplyRepo.findByJob(job);
	}

	public void addNew(JobSeekerApply jobSeekerApply) {
		jobSeekerApplyRepo.save(jobSeekerApply);
	}
}
