package com.mousika.security.model;

/**
 * 用户角色
 * @author xiaojf
 *
 */
public class UsRole {
	private String roleId;             //角色ID
	private String name;               //角色名称
	private boolean enable;            //是否可用
	
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
