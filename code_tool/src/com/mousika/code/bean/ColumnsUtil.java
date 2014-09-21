package com.mousika.code.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;

public class ColumnsUtil {
    static List<Table> tables;
    static Map<String , Collection<Column>> columns;
    /**
     *  根据获取字段集合
     * @return
     */
    public static Map getColumnsMap(){
        if(tables == null){
            tables = TableFactory.getInstance().getAllTables();
        }
        if(columns == null){
            columns = new LinkedHashMap();
            for(Table t : tables){
                columns.put(t.getSqlName().toLowerCase(), t.getColumns());
            }
        }
        return columns;
    }
    
    /**
     * 根据表名获取字段集合
     * @param tableName
     * @return
     */
    public static Object getColumnsByTableName(String tableName){
        LinkedHashSet<Column> columns = (LinkedHashSet<Column>) getColumnsMap().get(tableName);
        List<Column> list = new ArrayList<Column>();
        for (Column object : columns) {
            list.add(object);
        }
        return list;
    }
}   
