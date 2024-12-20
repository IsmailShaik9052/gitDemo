package com.demo.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorize -> authorize.requestMatchers("/loginUser", "/user").permitAll()
				.requestMatchers("/modify", "/delete").authenticated().anyRequest().authenticated())
				.formLogin(form -> form.defaultSuccessUrl("/user") // Will redirect to /user only if no specific URL was
																	// requested
				);

		return http.build();
	}
}
