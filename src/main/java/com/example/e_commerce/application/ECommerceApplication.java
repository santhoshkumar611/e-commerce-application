package com.example.e_commerce.application;

import com.example.e_commerce.application.model.User;
import com.example.e_commerce.application.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ECommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApplication.class, args);
	}

	// Add this method here
	@Bean
	CommandLineRunner addTestUser(UserRepository userRepository) {
		return args -> {
			if(!userRepository.existsByEmail("santhosh@example.com")) {
				User user = new User();
				user.setName("Santhosh");
				user.setEmail("santhosh@example.com");
				user.setPassword("123456"); // plaintext for now
				userRepository.save(user);
			}
		};
	}
}
