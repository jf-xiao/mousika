package com.mousika.security.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.mousika.security.model.UsAuthority;
import com.mousika.security.model.UsRole;
import com.mousika.security.util.SecurityJdbcUtil;

public class MousikaSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;// 资源和权限的关系

	public MousikaSecurityMetadataSource() {// 项目初始化过程中，加载资源 和权限
		this.loadResourceDefine();
	}

	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<UsAuthority> authorities = this.loadSysAuth();
			for (UsAuthority authority : authorities) {
				String authId = authority.getAuthId();
				List<UsRole> roles = this.loadRoldWithAuthId(authId);
				List<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				for (UsRole role : roles) {
					ConfigAttribute configAttribute = new SecurityConfig(role.getName());
					configAttributes.add(configAttribute);
				}

				resourceMap.put(authority.getUrl(), configAttributes);

			}
		}
	}

	/**
	 * 获取当前访问资源所需要的权限
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException {

		String requestUrl = ((FilterInvocation)object).getRequestUrl();
		System.out.println("requestUrl is " + requestUrl);
		if (resourceMap == null) {
			loadResourceDefine();
		}
		return resourceMap.get(requestUrl);
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	/**
	 * 获取系统资源和权限
	 * 
	 * @return
	 * @author jianfeng.xiao@foxmail.com 2014-4-27 下午1:31:56
	 */
	private List<UsAuthority> loadSysAuth() {
		ResultSet rs = null;
		List<UsAuthority> authorities = new ArrayList<UsAuthority>();

		SecurityJdbcUtil sql = new SecurityJdbcUtil();
		rs = sql.executeQuery("SELECT * FROM US_AUTHORITY WHERE enable = '1' ");
		try {
			while (rs.next()) {

				String authId = rs.getString("AUTH_ID");
				String name = rs.getString("NAME");
				boolean enable = rs.getBoolean("ENABLE");
				String url = rs.getString("URL");

				UsAuthority authority = new UsAuthority(authId, name, enable,
						url);
				authorities.add(authority);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authorities;
	}

	/**
	 * 加载访问某一路径所需要的权限
	 * 
	 * @param authId
	 * @return
	 * @author jianfeng.xiao@foxmail.com 2014-4-27 下午1:44:08
	 */
	private List<UsRole> loadRoldWithAuthId(String authId) {
		List<UsRole> roles = new ArrayList<UsRole>();
		ResultSet rs = null;
		SecurityJdbcUtil sql = new SecurityJdbcUtil();
		rs = sql.executeQuery("SELECT r.role_id,r.name,r.enable FROM us_role r,us_authority a,us_role_auth l WHERE r.role_id = l.role_id AND a.auth_id = l.auth_id AND a.auth_id = '"+authId+"'");
		try {
			while (rs.next()) {
				String roleId = rs.getString("role_id");
				String name = rs.getString("name");
				boolean enable = rs.getBoolean("enable");
				UsRole role = new UsRole(roleId, name, enable);
				roles.add(role);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return roles;
	}

}
