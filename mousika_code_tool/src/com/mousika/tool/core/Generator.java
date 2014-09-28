package com.mousika.tool.core;

import java.util.ArrayList;
import java.util.List;

import com.mousika.tool.bean.ColumnInfo;
import com.mousika.tool.bean.ConfigInfo;
import com.mousika.tool.bean.Constants;
import com.mousika.tool.bean.PrimaryKeyInfo;
import com.mousika.tool.bean.TableInfo;
import com.mousika.tool.bean.TemplateConfigInfo;
import com.mousika.tool.util.CamelCaseUtil;
import com.mousika.tool.util.PathUtil;
import com.mousika.tool.util.PrimaryKeyUtil;
import com.mousika.tool.util.VelocityUtil;
import com.mousika.velocity.params.ActionParams;
import com.mousika.velocity.params.DaoImplParams;
import com.mousika.velocity.params.DaoParams;
import com.mousika.velocity.params.ModelParams;
import com.mousika.velocity.params.ServiceImplParams;
import com.mousika.velocity.params.ServiceParams;

public class Generator {

    public static void generatorService(TableInfo tableInfo) {
        TemplateConfigInfo templateConfigInfo = ConfigInfo.tempConfigMap.get(Constants.SERVICE);
        String packageName =templateConfigInfo.getPackageStr();
        String modelName = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String modelPackage = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(packageName);
        
        ServiceParams params = new ServiceParams(packageName, modelName, modelPackage, tableInfo.getRemarks());
        
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.SERVICE).getTemplatePath(), outputPath,modelName+"Service.java");
    }

    public static void generatorAction(TableInfo tableInfo) {
        String servicePack = ConfigInfo.tempConfigMap.get(Constants.SERVICE).getPackageStr();
        String modelClass = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String modelPack = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String modelField = CamelCaseUtil.toCamelCase(tableInfo.getTableName());
        String actionPack = ConfigInfo.tempConfigMap.get(Constants.ACTION).getPackageStr();
        
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(actionPack);
        ActionParams params = new ActionParams(servicePack, modelClass, modelPack, modelField, actionPack);
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.ACTION).getTemplatePath(), outputPath,modelClass+"Controller.java");
    }

    public static void generatorModel(TableInfo tableInfo) {
        String modelClass = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String modelPack = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String modelField = CamelCaseUtil.toCamelCase(tableInfo.getTableName());
        String tableName = tableInfo.getTableName();
        List<ColumnInfo> columns= ConfigInfo.tabAndcolMap.get(tableName.toUpperCase());
        List<ColumnInfo> columnInfos = new ArrayList<ColumnInfo>();
        
        List<PrimaryKeyInfo> primaryKeyInfos = PrimaryKeyUtil.getTablePks(ConfigInfo.jdbcConfigInfo, tableName);
        List<String> keys = new ArrayList<String>();
        for(PrimaryKeyInfo keyInfo : primaryKeyInfos){
            keys.add(keyInfo.getColumnName().toUpperCase());
        }
        
        for(ColumnInfo columnInfo :columns){
            if(columnInfo.isEnable() == true){
                for(String key : keys){
                    if(key.equals(columnInfo.getColumnName().toUpperCase())){
                        columnInfo.setKey(true);
                    }
                }
                columnInfos.add(columnInfo);
            }
        }
        
        ModelParams params = new ModelParams(modelPack, modelClass, modelField, tableName, columnInfos,keys);
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(modelPack);
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.MODEL).getTemplatePath(), outputPath,modelClass+".java");
    }

    public static void generatorServiceImpl(TableInfo tableInfo) {
        String servicePack = ConfigInfo.tempConfigMap.get(Constants.SERVICE).getPackageStr();
        String modelClass = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String daoPack = ConfigInfo.tempConfigMap.get(Constants.DAO).getPackageStr();
        String modelPack = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String serviceImplPack = ConfigInfo.tempConfigMap.get(Constants.SERVICE_IMPL).getPackageStr();
        String modelField = CamelCaseUtil.toCamelCase(tableInfo.getTableName());
        
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(serviceImplPack);
        ServiceImplParams params = new ServiceImplParams(servicePack,modelClass,daoPack,modelPack,serviceImplPack,modelField);
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.SERVICE_IMPL).getTemplatePath(), outputPath,modelClass+"Service.java");
    }

    public static void generatorDao(TableInfo tableInfo) {
        String servicePack = ConfigInfo.tempConfigMap.get(Constants.SERVICE).getPackageStr();
        String modelClass = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String daoPack = ConfigInfo.tempConfigMap.get(Constants.DAO).getPackageStr();
        String modelPack = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String serviceImplPack = ConfigInfo.tempConfigMap.get(Constants.SERVICE_IMPL).getPackageStr();
        String modelField = CamelCaseUtil.toCamelCase(tableInfo.getTableName());
        
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(daoPack);
        DaoParams params = new DaoParams(servicePack,modelClass,daoPack,modelPack,serviceImplPack,modelField);
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.DAO).getTemplatePath(), outputPath,modelClass+"Dao.java");
        
    }

    public static void generatorDaoImpl(TableInfo tableInfo) {
        String servicePack = ConfigInfo.tempConfigMap.get(Constants.SERVICE).getPackageStr();
        String modelClass = CamelCaseUtil.toClassName(tableInfo.getTableName());
        String daoPack = ConfigInfo.tempConfigMap.get(Constants.DAO).getPackageStr();
        String daoImplPack = ConfigInfo.tempConfigMap.get(Constants.DAO_IMPL).getPackageStr();
        String modelPack = ConfigInfo.tempConfigMap.get(Constants.MODEL).getPackageStr();
        String serviceImplPack = ConfigInfo.tempConfigMap.get(Constants.SERVICE_IMPL).getPackageStr();
        String modelField = CamelCaseUtil.toCamelCase(tableInfo.getTableName());
        
        String outputPath = ConfigInfo.outputPath+"/"+PathUtil.pack2Path(daoImplPack);
        DaoImplParams params = new DaoImplParams(servicePack, modelClass, daoPack, modelPack, serviceImplPack, modelField, daoImplPack);
        VelocityUtil.generator(params, ConfigInfo.tempConfigMap.get(Constants.DAO_IMPL).getTemplatePath(), outputPath,modelClass+"DaoImpl.java");
        
    }

}
