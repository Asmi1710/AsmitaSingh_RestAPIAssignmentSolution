package com.greatlearning.employeemanagement.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.employeemanagement.service.EmployeeUserDetailsService;

@Configuration
@EnableWebSecurity
public class EmployeeWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

	// Customize Authentication
			@Override
			protected void configure(AuthenticationManagerBuilder auth) throws Exception {

				AuthenticationProvider authenticationProvider = customAuthenticationProvider();
				auth.authenticationProvider(authenticationProvider);
				
			}
			
			// 
			@Bean
			public UserDetailsService customUserDetailsService() {
				return new EmployeeUserDetailsService();
			}
			
			
			// this is for encoding our passwords
			@Bean
			public PasswordEncoder bcryptPasswordEncoder() {
				return new BCryptPasswordEncoder();
			}
			
			
			
			@Bean
			public DaoAuthenticationProvider customAuthenticationProvider() {
				
				DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
				
				// this helps us to use custom database for username and password
				daoProvider.setUserDetailsService(customUserDetailsService());
				daoProvider.setPasswordEncoder(bcryptPasswordEncoder());
				return daoProvider;
			}
			
			@Override
			public void configure(WebSecurity web) throws Exception {
				web.ignoring().antMatchers("/h2-console/**");
			}
			

			@Override
			protected void configure(HttpSecurity http) throws Exception {
				
				http.authorizeRequests()
				.antMatchers("/employee/addEmployee", "/h2-console/**")
				.hasAuthority("ADMIN")
				.antMatchers("/", "/login", "/employees/**", "/role/**","/users/**","/employee/deleteEmployee","/employee/updateEmployee",
						"/employee/getEmployeeById")
				.hasAnyAuthority("USER", "ADMIN").anyRequest().authenticated().and().formLogin()
				.loginProcessingUrl("/login").successForwardUrl("/").permitAll().and().logout()
				.logoutSuccessUrl("/login").permitAll()

				.and().cors().and().csrf().disable();
		}	
}
