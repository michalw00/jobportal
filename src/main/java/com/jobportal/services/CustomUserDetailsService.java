package com.jobportal.services;

import com.jobportal.entities.Users;
import com.jobportal.repository.UsersRepo;
import com.jobportal.util.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UsersRepo usersRepo;

	@Autowired
	public CustomUserDetailsService(UsersRepo usersRepo) {
		this.usersRepo = usersRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersRepo.findByEmail(username).orElseThrow(
				()-> new UsernameNotFoundException("Could not find user"));
		return new CustomUserDetails(user);
	}
}
