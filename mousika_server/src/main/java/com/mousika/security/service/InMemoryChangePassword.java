package com.mousika.security.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.memory.InMemoryDaoImpl;

public class InMemoryChangePassword extends InMemoryDaoImpl implements IChangePassword {

	@Override
	public void changePassword(String username, String password) {
		User userDetails = (User) this.getUserMap().getUser(username);
		User newUserDetails = new User(userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled(),
				userDetails.isAccountNonExpired(), userDetails.isCredentialsNonExpired(), userDetails.isAccountNonLocked(),
				userDetails.getAuthorities());
		this.getUserMap().addUser(newUserDetails);
	}

}
