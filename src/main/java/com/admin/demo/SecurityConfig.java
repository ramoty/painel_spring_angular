package com.admin.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("org.baeldung.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationProvider authProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/js/**").anonymous()
		.antMatchers("/css/**").anonymous()
		.antMatchers("/login*").anonymous()
		.antMatchers("/*").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login.html").defaultSuccessUrl("/home.html").failureUrl("/login.html?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/login.html");
		
		http.exceptionHandling().accessDeniedPage("/403");
	}
}
