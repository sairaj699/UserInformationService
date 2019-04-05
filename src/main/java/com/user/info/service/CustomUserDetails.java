package com.user.info.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.user.info.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		
		//return user.getRoles().stream().map(role-> new SimpleGrantedAuthority("role" +role.getRole())).collect(Collectors.toList());
		 return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassWord();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
