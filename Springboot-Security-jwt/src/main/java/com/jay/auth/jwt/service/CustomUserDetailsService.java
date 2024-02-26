package com.jay.auth.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>(); 
        SimpleGrantedAuthority userRole = new SimpleGrantedAuthority("USER"); 
        SimpleGrantedAuthority adminRole = new SimpleGrantedAuthority("ADMIN");

        roles.add(userRole);
        roles.add(adminRole);
          
		return new User("user", "pass", roles);
	}

}
