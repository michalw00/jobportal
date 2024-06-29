package com.jobportal.controller;

import com.jobportal.entities.JobPostActivity;
import com.jobportal.services.JobPostActivityService;
import com.jobportal.services.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobSeekerApplyController {

	private final JobPostActivityService jobPostActivityService;
	private final UsersService usersService;

	public JobSeekerApplyController(JobPostActivityService jobPostActivityService, UsersService usersService) {
		this.jobPostActivityService = jobPostActivityService;
		this.usersService = usersService;
	}

	@GetMapping("job-details-apply/{id}")
	public String display(@PathVariable("id") int id, Model model) {
		JobPostActivity jobDetails = jobPostActivityService.getOne(id);

		model.addAttribute("jobDetails", jobDetails);
		model.addAttribute("user", usersService.getCurrentUserProfile());

		return "job-details";
	}
}
