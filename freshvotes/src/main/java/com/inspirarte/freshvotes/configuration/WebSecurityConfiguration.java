package com.inspirarte.freshvotes.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// this is used to test the login functionality
		auth.inMemoryAuthentication()
			.withUser("vic")
			.password("password")
			.roles("USER")
		.and()
			.withUser("admin")
			.password("password")
			.roles("USER", "ADMIN");
			
		//super.configure(auth);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/ping").permitAll()
		.anyRequest().hasRole("USERS")
		.and().formLogin()
			.loginPage("/login").permitAll()
		.and().logout()
			.logoutUrl("/logout").permitAll();
		
		//super.configure(http);
	}
	
	

}
