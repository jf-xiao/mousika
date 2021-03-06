package com.mousika.security.service;

import java.util.List;

import com.mousika.security.domain.UsAuthority;

/**
 * 权限SERVICE
 * @author xiaojf 294825811@qq.com
 */
public interface UsAuthorityService {
    /**
     * 获取系统可用权限
     * 
     * @return
     */
    List<UsAuthority> getEffectiveAuth();

}
