package com.mousika.velocity.params;

/**
 * dao impl params对象
 * @author xiaojf 294825811@qq.com
 */
public class DaoImplParams {

    private String servicePack = "";        //service 包,如com.mousika.user.service
    private String modelClass = "";         //model 类名,如User
    private String daoPack = "";            //dao包, 如com.mousika.user.dao
    private String modelPack = "";          //model包, 如com.mousika.user.model
    private String serviceImplPack = "";    //serviceImpl包, 如com.mousika.user.service.impl
    private String modelField = "";         //如 usUser
    private String daoImplPack = "";        //daoImpl包, 如com.mousika.user.dao.impl
    private String modelRemarks = "";       //表注释,如User表的注释, 用户
    public DaoImplParams() {
        super();
    }




    public DaoImplParams(String servicePack, String modelClass, String daoPack, String modelPack,
            String serviceImplPack, String modelField, String daoImplPack) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.daoPack = daoPack;
        this.modelPack = modelPack;
        this.serviceImplPack = serviceImplPack;
        this.modelField = modelField;
        this.daoImplPack = daoImplPack;
    }




    public DaoImplParams(String servicePack, String modelClass, String daoPack, String modelPack, String serviceImplPack, String modelField, String daoImplPack, String modelRemarks) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.daoPack = daoPack;
        this.modelPack = modelPack;
        this.serviceImplPack = serviceImplPack;
        this.modelField = modelField;
        this.daoImplPack = daoImplPack;
        this.modelRemarks = modelRemarks;
    }




    public String getModelRemarks() {
        return modelRemarks == null ? "" : modelRemarks;
    }




    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
    }




    public String getDaoImplPack() {
        return daoImplPack == null ? "" : daoImplPack;
    }




    public void setDaoImplPack(String daoImplPack) {
        this.daoImplPack = daoImplPack;
    }




    public String getServicePack() {
        return servicePack == null ? "" : servicePack;
    }


    public void setServicePack(String servicePack) {
        this.servicePack = servicePack;
    }


    public String getModelClass() {
        return modelClass == null ? "" : modelClass;
    }


    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }


    public String getDaoPack() {
        return daoPack == null ? "" : daoPack;
    }


    public void setDaoPack(String daoPack) {
        this.daoPack = daoPack;
    }


    public String getModelPack() {
        return modelPack == null ? "" : modelPack;
    }


    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }


    public String getServiceImplPack() {
        return serviceImplPack == null ? "" : serviceImplPack;
    }


    public void setServiceImplPack(String serviceImplPack) {
        this.serviceImplPack = serviceImplPack;
    }



    public String getModelField() {
        return modelField == null ? "" : modelField;
    }



    public void setModelField(String modelField) {
        this.modelField = modelField;
    }
    
    

}
