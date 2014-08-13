package com.mousika.security.service;

import java.util.List;

import com.mousika.security.domain.UsAuthority;

public interface UsAuthorityService {
    /**
     * 获取系统可用权限
     * @return
     */
    List<UsAuthority> getEffectiveAuth();

}
