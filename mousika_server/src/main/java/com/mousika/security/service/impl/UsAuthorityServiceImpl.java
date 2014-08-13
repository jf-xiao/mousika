package com.mousika.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mousika.security.dao.UsAuthorityDao;
import com.mousika.security.domain.UsAuthority;
import com.mousika.security.service.UsAuthorityService;

@Transactional
@Service(value="usAuthorityService")
public class UsAuthorityServiceImpl implements UsAuthorityService {
    @Resource(name="usAuthorityDao")
    private UsAuthorityDao usAuthorityDao;

    @Override
    public List<UsAuthority> getEffectiveAuth() {
        return usAuthorityDao.getEffectiveAuth();
    }

}
