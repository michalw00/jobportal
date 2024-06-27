package com.jobportal.services;

import com.jobportal.entities.UsersType;
import com.jobportal.repository.UsersTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersTypeService {

	private final UsersTypeRepo usersTypeRepo;

	@Autowired
	public UsersTypeService(UsersTypeRepo usersTypeRepo) {
		this.usersTypeRepo = usersTypeRepo;
	}

	public List<UsersType> getAll() {
		return usersTypeRepo.findAll();
	}
}
