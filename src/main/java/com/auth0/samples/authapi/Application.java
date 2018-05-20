package com.auth0.samples.authapi;

import com.auth0.samples.authapi.task.Task;
import com.auth0.samples.authapi.task.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(TaskRepository taskRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				taskRepository.save(new Task("Buy groceries from Walmart."));
				taskRepository.save(new Task("Call mom."));
				taskRepository.save(new Task("Go to school to pick up kids."));
			}
		};
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
