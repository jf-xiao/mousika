package com.mousika.security.dao.impl;

import org.springframework.stereotype.Repository;

import com.mousika.common.dao.impl.BaseDaoImpl;
import com.mousika.security.dao.UsRoleDao;
import com.mousika.security.domain.UsRole;
/**
 * 角色DAO实现类
 * @author xiaojf 294825811@qq.com
 */
@Repository(value="usRoleDao")
public class UsRoleDaoImpl extends BaseDaoImpl<UsRole> implements UsRoleDao {

}