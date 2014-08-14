package com.mousika.security.dao;

import java.util.List;

import com.mousika.common.dao.BaseDao;
import com.mousika.security.domain.UsRoleAuth;

public interface UsRoleAuthDao extends BaseDao<UsRoleAuth> {
    /**
     * 获取某个权限所需角色
     * @param authId
     * @return
     */
    List<UsRoleAuth> getByAuthId(String authId);

}
