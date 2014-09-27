package com.mousika.velocity.params;

import java.util.List;

import com.mousika.tool.bean.ColumnInfo;

public class ModelParams {
    private String modelPack;
    private String modelClass;
    private String modelField;
    
    private String tableName;
    
    private List<String> keys;
    
    List<ColumnInfo> columnInfos ;
    
    

    public ModelParams() {
        super();
    }
    
    

    public ModelParams(String modelPack, String modelClass, String modelField, String tableName,
            List<ColumnInfo> columnInfos,List<String> keys) {
        super();
        this.modelPack = modelPack;
        this.modelClass = modelClass;
        this.modelField = modelField;
        this.tableName = tableName;
        this.columnInfos = columnInfos;
        this.keys = keys;
    }



    public String getModelPack() {
        return modelPack;
    }

    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }

    public String getModelClass() {
        return modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }

    public String getModelField() {
        return modelField;
    }

    public void setModelField(String modelField) {
        this.modelField = modelField;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnInfo> getColumnInfos() {
        return columnInfos;
    }

    public void setColumnInfos(List<ColumnInfo> columnInfos) {
        this.columnInfos = columnInfos;
    }



    public List<String> getKeys() {
        return keys;
    }



    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
    
    
    
}
