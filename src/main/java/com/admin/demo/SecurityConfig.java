package com.admin.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
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
	
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("admin").password("123");
//    }
	
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
	    return new ProviderManager(Arrays.asList((AuthenticationProvider) new CustomAuthenticationProvider()));
	}

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
		.antMatchers("/assets*").anonymous()
		.antMatchers("/pages*").anonymous()
		.antMatchers("/*").anonymous()
//		.antMatchers("/*").hasRole("ADMIN")
//		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login.html").defaultSuccessUrl("/admin.html").failureUrl("/login.html?error=true").permitAll()
		.and().logout().logoutSuccessUrl("/login.html");
		
		http.exceptionHandling().accessDeniedPage("/403");
	}
}
