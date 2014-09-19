package com.mousika.security.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.mousika.common.dao.impl.BaseDaoImpl;
import com.mousika.security.dao.UsRoleAuthDao;
import com.mousika.security.domain.UsRoleAuth;
/**
 * 角色-权限 DAO实现类
 * @author xiaojf
 *
 */
@Repository(value="usRoleAuthDao")
public class UsRoleAuthDaoImpl extends BaseDaoImpl<UsRoleAuth> implements UsRoleAuthDao {

    @Override
    public List<UsRoleAuth> getByAuthId(String authId) {
        Session session = super.getSessionFactory().getCurrentSession();
        return session.createQuery("from UsRoleAuth where authId = ?").setString(0, authId).list();
    }
}
