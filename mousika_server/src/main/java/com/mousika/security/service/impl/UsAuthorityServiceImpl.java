package com.mousika.security.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mousika.security.dao.UsAuthorityDao;
import com.mousika.security.domain.UsAuthority;
import com.mousika.security.service.UsAuthorityService;

/**
 * 权限SERVICE实现类
 * @author xiaojf 294825811@qq.com
 */
@Transactional
@Service(value="usAuthorityService")
public class UsAuthorityServiceImpl implements UsAuthorityService {
    @Resource(name="usAuthorityDao")
    private UsAuthorityDao usAuthorityDao;

    @Override
    public List<UsAuthority> getEffectiveAuth() {
        List<UsAuthority> authorities = usAuthorityDao.getEffectiveAuth();
        if(authorities == null){
            authorities = new ArrayList<UsAuthority>();
        }
        return authorities;
    }

}
