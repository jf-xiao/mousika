package com.mousika.tool.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.Constants;
import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.bean.TemplateConfigInfo;

/**
 * 核心操作类
 * @author xiaojf 294825811@qq.com
 */
public class MainOperate {
    /**
     * 生产文件
     * @return 是否成功
     * @author xiaojf 294825811@qq.com
     */
    public static String generatorFiles() {

        Map<Constants, TemplateConfigInfo> tempConfigMap = ConfigInfo.tempConfigMap;

        for (TableInfo tableInfo : ConfigInfo.tableInfos) {
            if (tableInfo.isEnable()) {
                //生产ACTION
                if (tempConfigMap.get(Constants.ACTION).isEnable()) {
                    Generator.generatorAction(tableInfo);
                }
                
                //生产MODEL
                if (tempConfigMap.get(Constants.MODEL).isEnable()) {

                    Generator.generatorModel(tableInfo);
                }
                
                //生产DAO_IMPL
                if (tempConfigMap.get(Constants.DAO_IMPL).isEnable()) {

                    Generator.generatorDaoImpl(tableInfo);
                }
                
                //生产DAO
                if (tempConfigMap.get(Constants.DAO).isEnable()) {
                    Generator.generatorDao(tableInfo);

                }
                
                //生产SERVICE_IMPL
                if (tempConfigMap.get(Constants.SERVICE_IMPL).isEnable()) {
                    Generator.generatorServiceImpl(tableInfo);
                }
                
                //生产SERVICE_IMPL
                if (tempConfigMap.get(Constants.SERVICE).isEnable()) {
                    Generator.generatorService(tableInfo);
                }
            }
        }

        return "生产成功";
    }
    
    /**
     * 加载数据库的表信息
     * @param jdbcConfigInfo jdbc配置信息
     * @return 表集合
     * @author xiaojf 294825811@qq.com
     */
    public static List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();
        
        if("ORACLE".equals(jdbcConfigInfo.getType().toUpperCase())){        //ORACLE数据库
            tableInfos = new OracleOperator().loadTableInfo(jdbcConfigInfo);
        }else if("MYSQL".equals(jdbcConfigInfo.getType().toUpperCase())){   //MYSQL数据库
            tableInfos = new MySqlOperator().loadTableInfo(jdbcConfigInfo);
        }
        return tableInfos;
    }
}
