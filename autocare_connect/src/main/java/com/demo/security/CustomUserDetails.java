package com.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.beans.UserRole;

public class CustomUserDetails implements UserDetails{
     private UserRole userRole;
     
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUser(UserRole userRole) {
		this.userRole = userRole;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}

	public String getPassword() {
		System.out.println("in getPassword CustomUserDetails");
		return userRole.getPassword();
	}

	public String getUsername() {
		System.out.println("in getusername CustomUserDetails");
		return userRole.getEmail();
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

}
