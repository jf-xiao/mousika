package com.mousika.security.model;

/**
 * 用户-角色关联
 * @author xiaojf
 *
 */
public class UsUserRole {
	private String userId;                 //用户主键
	private String roleId;                 //角色主键

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
