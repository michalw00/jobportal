package com.jobportal.repository;

import com.jobportal.entities.IRecruiterJobs;
import com.jobportal.entities.JobPostActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobPostActivityRepo extends JpaRepository<JobPostActivity, Integer> {

	// Retrieves list of jobs for a given recruiter id
	// Combines/joins job post activity, job location, company
	// Also includes a count of job seekers/candidates who have applied for a given job
	@Query(value = " SELECT COUNT(s.user_id) as totalCandidates,j.job_post_id,j.job_title,l.id as locationId,l.city,l.state,l.country,c.id as companyId,c.name FROM job_post_activity j " +
			" inner join job_location l " +
			" on j.job_location_id = l.id " +
			" INNER join job_company c  " +
			" on j.job_company_id = c.id " +
			" left join job_seeker_apply s " +
			" on s.job = j.job_post_id " +
			" where j.posted_by_id = :recruiter " +
			" GROUP By j.job_post_id", nativeQuery = true) // native SQL query, not JPQL
	List<IRecruiterJobs> getRecruiterJobs(@Param("recruiter") int recruiter);

}
