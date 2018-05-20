package com.auth0.samples.authapi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class ApplicationUserController {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/sign-up")
	private void signUpTheUser(@RequestBody ApplicationUser applicationUser) {
		applicationUser.setPassword(bCryptPasswordEncoder.encode(applicationUser.getPassword()));
		applicationUserRepository.save(applicationUser);
	}
}
