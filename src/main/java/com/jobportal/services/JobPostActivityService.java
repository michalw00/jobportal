package com.jobportal.services;

import com.jobportal.entities.*;
import com.jobportal.repository.JobPostActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

	public List<RecruiterJobsDto> getRecruiterJobs(int recruiter) {

		List<IRecruiterJobs> recruiterJobsDtos = jobPostActivityRepo.getRecruiterJobs(recruiter);

		List<RecruiterJobsDto> recruiterJobsDtoList = new ArrayList<>();

		for (IRecruiterJobs rec : recruiterJobsDtos) {
			JobLocation loc = new JobLocation(rec.getLocationId(), rec.getCity(),
					rec.getState(), rec.getCountry());
			JobCompany comp = new JobCompany(rec.getCompanyId(), rec.getName(), "");
			recruiterJobsDtoList.add(new RecruiterJobsDto(rec.getTotalCondidates(),
					rec.getJob_post_id(), rec.getJob_title(), loc, comp));
		}
		return recruiterJobsDtoList;
	}

	public JobPostActivity getOne(int id) {
		return jobPostActivityRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Job not found"));
	}
}
