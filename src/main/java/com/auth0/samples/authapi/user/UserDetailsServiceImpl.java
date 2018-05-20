package com.auth0.samples.authapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	ApplicationUserRepository applicationUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApplicationUser applicationUser = applicationUserRepository.findByUsername(username);

		if(applicationUser == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(applicationUser.getUsername(), applicationUser.getPassword(), Collections.emptyList());
	}
}
