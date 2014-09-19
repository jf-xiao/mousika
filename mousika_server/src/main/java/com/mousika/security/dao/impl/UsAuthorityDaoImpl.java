package com.mousika.security.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mousika.common.dao.impl.BaseDaoImpl;
import com.mousika.security.dao.UsAuthorityDao;
import com.mousika.security.domain.UsAuthority;
/**
 * 权限DAO实现类
 * @author xiaojf
 *
 */
@Repository(value="usAuthorityDao")
public class UsAuthorityDaoImpl extends BaseDaoImpl<UsAuthority> implements UsAuthorityDao {

    @Override
    public List<UsAuthority> getEffectiveAuth() {
        Session session = this.getSessionFactory().getCurrentSession();
        return session.createQuery("from UsAuthority auth where auth.enable != 0 and auth.enable != 'false'").list();
    }

}
