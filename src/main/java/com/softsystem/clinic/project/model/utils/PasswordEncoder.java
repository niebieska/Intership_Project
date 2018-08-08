package com.softsystem.clinic.project.model.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordEncoder {

	@Bean
	public static String encodePass(String text) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(text);

		return hashedPassword;
	}

	@Autowired
	public static boolean checkPassword(String providedPassword, String hashedPasswordFromDatabase) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		return passwordEncoder.matches(providedPassword, hashedPasswordFromDatabase);
	}
}
