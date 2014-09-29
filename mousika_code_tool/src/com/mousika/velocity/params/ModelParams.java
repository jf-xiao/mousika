package com.mousika.velocity.params;

import java.util.List;

import com.mousika.tool.bean.ColumnInfo;

/**
 * model params对象
 * @author xiaojf 294825811@qq.com
 */
public class ModelParams {
    private String modelPack = "";      //model包, 如com.mousika.user.model
    private String modelClass = "";     //model 类名,如User
    private String modelField = "";     //如usUser
    
    private String tableName = "";      //表名US_USER
    private String modelRemarks = "";   //表注释,如User表的注释, 用户
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



    public ModelParams(String modelPack, String modelClass, String modelField, String tableName, String modelRemarks, List<String> keys, List<ColumnInfo> columnInfos) {
        super();
        this.modelPack = modelPack;
        this.modelClass = modelClass;
        this.modelField = modelField;
        this.tableName = tableName;
        this.modelRemarks = modelRemarks;
        this.keys = keys;
        this.columnInfos = columnInfos;
    }



    public String getModelRemarks() {
        return modelRemarks == null ? "" : modelRemarks;
    }



    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
    }



    public String getModelPack() {
        return modelPack == null ? "" : modelPack;
    }

    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }

    public String getModelClass() {
        return modelClass == null ? "" : modelClass;
    }

    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }

    public String getModelField() {
        return modelField == null ? "" : modelField;
    }

    public void setModelField(String modelField) {
        this.modelField = modelField;
    }

    public String getTableName() {
        return tableName == null ? "" : tableName;
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
        return keys ;
    }



    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
    
    
    
}
