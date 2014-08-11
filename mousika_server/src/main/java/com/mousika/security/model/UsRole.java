package com.mousika.security.model;

public class UsRole {
	private String roleId;
	private String name;
	private boolean enable;
	
	public UsRole() {
	}
	
	public UsRole(String roleId, String name, boolean enable) {
		super();
		this.roleId = roleId;
		this.name = name;
		this.enable = enable;
	}



	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

}
