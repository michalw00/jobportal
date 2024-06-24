package com.jobportal.services;

import com.jobportal.entities.RecruiterProfile;
import com.jobportal.repository.RecruiterProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {

	private final RecruiterProfileRepo recruiterProfileRepo;

	@Autowired
	public RecruiterProfileService(RecruiterProfileRepo recruiterProfileRepo) {
		this.recruiterProfileRepo = recruiterProfileRepo;
	}

	public Optional<RecruiterProfile> getOne(Integer id) {
		return recruiterProfileRepo.findById(id);
	}

	public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
		return recruiterProfileRepo.save(recruiterProfile);
	}
}
