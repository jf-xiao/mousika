package com.mousika.security.service;

import java.util.List;

import com.mousika.security.domain.UsRole;


public interface UsRoleService {
    /**
     * 根据权限ID获取所需角色
     * @param authId 权限ID 
     * @return
     */
    List<UsRole> getRolesByAuth(String authId);
    /**
     * 新增角色
     * @param role
     */
    void addRole(UsRole role);
}
