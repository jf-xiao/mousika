package com.mousika.tool.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mousika.tool.bean.ColumnInfo;
import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.Constants;
import com.mousika.tool.bean.JdbcConfigInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.bean.TemplateConfigInfo;
import com.mousika.tool.util.ConnectionUtil;

/**
 * 核心操作类
 * 
 * @author xiaojf
 * 
 */
public class MainOperate {

    public static String generatorFiles() {
        Map<Constants, TemplateConfigInfo> tempConfigMap = ConfigInfo.tempConfigMap;

        for (TableInfo tableInfo : ConfigInfo.tableInfos) {
            if (tableInfo.isEnable()) {
                if (tempConfigMap.get(Constants.ACTION).isEnable()) {
                    Generator.generatorAction(tableInfo);

                }
                if (tempConfigMap.get(Constants.MODEL).isEnable()) {

                    Generator.generatorModel(tableInfo);
                }
                if (tempConfigMap.get(Constants.DAO_IMPL).isEnable()) {

                    Generator.generatorDaoImpl(tableInfo);
                }
                if (tempConfigMap.get(Constants.DAO).isEnable()) {
                    Generator.generatorDao(tableInfo);

                }
                if (tempConfigMap.get(Constants.SERVICE_IMPL).isEnable()) {
                    Generator.generatorServiceImpl(tableInfo);

                }
                if (tempConfigMap.get(Constants.SERVICE).isEnable()) {
                    Generator.generatorService(tableInfo);
                }
            }
        }

        return "生产成功";
    }

    public static List<TableInfo> loadTableInfo(JdbcConfigInfo jdbcConfigInfo) {
        List<TableInfo> tableInfos = new ArrayList<TableInfo>();
        Map<String, List<ColumnInfo>> tabAndcolMap = new HashMap<String, List<ColumnInfo>>();
        
        if("ORACLE".equals(jdbcConfigInfo.getType().toUpperCase())){
            tableInfos = OracleOperator.loadTableInfo(jdbcConfigInfo);
        }else if("MYSQL".equals(jdbcConfigInfo.getType().toUpperCase())){
            tableInfos = MySqlOperator.loadTableInfo(jdbcConfigInfo);
        }
        return tableInfos;
    }
}
