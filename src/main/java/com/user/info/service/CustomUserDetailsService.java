package com.user.info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.info.dao.UserRepo;
import com.user.info.entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	private CustomUserDetails userdetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	User user = userRepo.findByUserName(username);
	if(user!=null) {
		userdetails = new CustomUserDetails();
		userdetails.setUser(user);
	}
	else {
		throw new UsernameNotFoundException("user not found with name :: " +username);
	}
	return userdetails;
	}

}
