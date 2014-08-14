package com.mousika.security.service.impl;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mousika.security.domain.UsRole;
import com.mousika.security.service.UsRoleService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UsRoleServiceImplTest {
    @Resource(name = "usRoleService")
    private UsRoleService usRoleService;
    @Test
    public void testAddRole() {
        UsRole role = new UsRole();
        role.setEnable("true");
        role.setName("newRole");
        role.setEnable("true");
        
        usRoleService.addRole(role);
    }

}
