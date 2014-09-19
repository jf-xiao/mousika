package com.mousika.security.dao;

import java.util.List;

import com.mousika.common.dao.BaseDao;
import com.mousika.security.domain.UsAuthority;
/**
 * 权限DAO
 * @author xiaojf
 *
 */
public interface UsAuthorityDao extends BaseDao<UsAuthority> {
    /**
     * 获取系统可用的权限
     * @return
     */
    List<UsAuthority> getEffectiveAuth();

}
