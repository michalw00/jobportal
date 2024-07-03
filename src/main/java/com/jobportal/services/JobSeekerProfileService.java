package com.jobportal.services;

import com.jobportal.entities.JobSeekerProfile;
import com.jobportal.entities.Users;
import com.jobportal.repository.JobSeekerRepo;
import com.jobportal.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobSeekerProfileService {
	private JobSeekerRepo jobSeekerRepo;
	private UsersRepo usersRepo;

	@Autowired
	public JobSeekerProfileService(JobSeekerRepo jobSeekerRepo, UsersRepo usersRepo) {
		this.jobSeekerRepo = jobSeekerRepo;
		this.usersRepo = usersRepo;
	}

	public Optional<JobSeekerProfile> getOne(Integer id) {
		return jobSeekerRepo.findById(id);
	}

	public JobSeekerProfile addNew(JobSeekerProfile jobSeekerProfile) {
		return jobSeekerRepo.save(jobSeekerProfile);
	}

	public JobSeekerProfile getCurrentSeekerProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUsername = authentication.getName();
			Users users = usersRepo.findByEmail(currentUsername).orElseThrow(
					()->new UsernameNotFoundException("User now found"));
			Optional<JobSeekerProfile> seekerProfile = getOne(users.getUserId());
			return seekerProfile.orElse(null);
		} else return null;
	}
}
