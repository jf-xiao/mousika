package com.mousika.security.model;

public class UsAuthority {
	private String authId;
	private String name;
	private boolean enable;
	private String url;
	
	public UsAuthority() {
	}
	
	public UsAuthority(String authId, String name, boolean enable, String url) {
		super();
		this.authId = authId;
		this.name = name;
		this.enable = enable;
		this.url = url;
	}



	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
