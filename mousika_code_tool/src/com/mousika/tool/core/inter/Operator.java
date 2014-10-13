/**
 * 
 */
package com.mousika.tool.core.inter;

import java.util.List;

import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.TableInfo;

/**
 * 数据库操作接口
 * @author xiaojf 294825811@qq.com
 */
public interface Operator {
    public List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo);
}
