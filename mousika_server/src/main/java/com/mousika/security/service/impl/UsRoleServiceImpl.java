package com.mousika.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mousika.security.dao.UsRoleAuthDao;
import com.mousika.security.dao.UsRoleDao;
import com.mousika.security.domain.UsRole;
import com.mousika.security.domain.UsRoleAuth;
import com.mousika.security.service.UsRoleService;

@Transactional
@Service(value="usRoleService")
public class UsRoleServiceImpl implements UsRoleService {
    @Resource(name="usRoleAuthDao")
    private UsRoleAuthDao usRoleAuthDao;
    @Resource(name="usRoleDao")
    private UsRoleDao usRoleDao;
    @Override
    public List<UsRole> getRolesByAuth(String authId) {
        List<UsRoleAuth> roleAuths =  usRoleAuthDao.getByAuthId(authId);
        List<String> roleIds = new ArrayList<String>();
        List<UsRole> roles = new ArrayList<UsRole>();
        if(roleAuths != null){
            for(UsRoleAuth roleAuth : roleAuths){
                roleIds.add(roleAuth.getRoleId());
            }
            
            roles = usRoleDao.get(roleIds);
        }
        return roles;
    }
    
    public void addRole(UsRole role){
        usRoleDao.add(role);
    }
}
