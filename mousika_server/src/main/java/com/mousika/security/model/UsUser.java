package com.mousika.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String userId;
	private String username;
	private String password;
	private String salt;
	private boolean enable;
	private String nickName;
	private String email;
	private String name;
	private String address;
	private Collection<? extends GrantedAuthority> authorities;
	
	public UsUser() {
	}
	
	public UsUser(String userId, String username, String password, String salt,
			boolean enable, String nickName, String email, String name,
			String address) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.salt = salt;
		this.enable = enable;
		this.nickName = nickName;
		this.email = email;
		this.name = name;
		this.address = address;
	}
	
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enable;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enable;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enable;
	}

	@Override
	public boolean isEnabled() {
		return this.enable;
	}



}
