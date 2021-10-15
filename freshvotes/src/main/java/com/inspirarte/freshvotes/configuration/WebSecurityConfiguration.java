package com.inspirarte.freshvotes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.databind.JsonNode;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// this is used to test the login functionality
		auth.inMemoryAuthentication()
			.passwordEncoder(getPasswordEncoder())
			.withUser("vic")
			.password(getPasswordEncoder().encode("pwd"))
			.roles("USER");
//		.and()
//			.passwordEncoder(getPasswordEncoder())
//			.withUser("admin")
//			.password(getPasswordEncoder().encode("password"))
//			.roles("USER", "ADMIN");
			
		//super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http.csrf().disable()
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/ping").permitAll()
			.anyRequest().hasRole("USER")
		.and().formLogin()
			.loginPage("/login").permitAll()	
		.and().logout()
			.logoutUrl("/logout").permitAll();
	}
}
