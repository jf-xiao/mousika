package com.mousika.common.dao;

import java.util.List;
import java.util.Map;
/**
 * 公共数据访问接口
 * @author xiaojf
 * @param <T>
 */
public interface BaseDao<T> {
    /**
     * 新增
     * @param domain 对象
     */
    public void add(T domain);
    /**
     * 新增
     * @param domains 对象集合
     */
    public void add(List<T> domains);
    /**
     * 删除
     * @param ids 主键集合
     */
    public void delete(List<String> ids);
    /**
     * 删除
     * @param id 主键
     */
    public void delete(String id);
    /**
     * 更新
     * @param domain 对象
     */
    public void update(T domain);
    /**
     * 更新
     * @param domains 对象集合
     */
    public void update(List<T> domains);
    /**
     * 获取
     * @param id 主键
     * @return
     */
    public T get(String id);
    /**
     * 查找
     * @param hql hql语句
     * @param params 参数
     * @return
     */
    public List<T> find(String hql,Map<String, Object> params);
    /**
     * 获取
     * @param ids 主键集合
     * @return 对象集合
     */
    public List<T> get(List<String> ids);
    /**
     * 获取所有
     * @return 对象集合
     */
    public List<T> getAll();
    /**
     * 执行hql语句
     * @param hql hql语句
     */
    public void execute(String hql);
    /**
     * 执行hql语句
     * @param hql hql语句
     */
    public void execute(String hql,Map<String, Object> params);
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页大小
     * @return 对象集合
     */
    public List<T> findByPage(int pageNo ,int pageSize);
    /**
     * 分页查询
     * @param pageNo 页号
     * @param pageSize 每页大小
     * @param params 参数
     * @return 对象集合
     */
    public List<T> findByPage(int pageNo ,int pageSize, Map<String, Object> params);
    /**
     * 获取惟一值
     * @param hql hql语句
     * @param params 参数
     * @return 惟一值
     */
    public Object unique(String hql ,Map<String, Object> params);

}
