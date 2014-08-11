package com.mousika.common.dao.interceptor;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
/**
 * 自动为保存操作更新 创建时间以及修改时间
 * @author xiaojf
 *
 */
public class MySaveOrUpdateInterceptor extends EmptyInterceptor {
    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state,String[] propertyNames, Type[] types) {
        for (int i = 0; i < propertyNames.length; i++) {
            if((id == null  || id.equals("")) && "createTime".equals(propertyNames[i])){
                state[i] = new Date();
            }
            
            if("updateTime".equals(propertyNames[i])){
                state[i] = new Date();
            }
        }
        
        return super.onSave(entity, id, state, propertyNames, types);
    }
}
