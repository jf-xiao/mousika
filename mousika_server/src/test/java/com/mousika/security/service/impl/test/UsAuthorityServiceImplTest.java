package com.mousika.security.service.impl.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mousika.security.domain.UsAuthority;
import com.mousika.security.service.UsAuthorityService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")

public class UsAuthorityServiceImplTest {
    @Resource(name="usAuthorityService")
    private UsAuthorityService authorityService;
    
    @Test
    @Ignore
    public void testGetEffectiveAuth() {
        List<UsAuthority> list = authorityService.getEffectiveAuth();
        System.out.println(list.size()+"--------------------");
        assertEquals(list.size(),1);
    }

}
