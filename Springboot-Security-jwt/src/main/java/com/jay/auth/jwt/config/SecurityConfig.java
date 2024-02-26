package com.jay.auth.jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jay.auth.jwt.controller.JwtRequestFilter;
import com.jay.auth.jwt.service.CustomUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = new CustomUserDetailsService().loadUserByUsername("user1");
        return new InMemoryUserDetailsManager(user);
    }
	
	@Bean
	public PasswordEncoder passwordEncorder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf().disable()
	    	.authorizeHttpRequests((authorize) -> 
	    		{
					try {
						authorize.requestMatchers("/authenticate")
						.permitAll()
						.anyRequest()
						.authenticated().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	    
	    http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	    
	    return http.build();
	}
	
}
