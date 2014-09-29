package com.mousika.velocity.params;

/**
 * service impl params对象
 * @author xiaojf 294825811@qq.com
 */
public class ServiceImplParams {

    private String servicePack = "";        //service 包,如com.mousika.user.service
    private String modelClass = "";         //service 包,如com.mousika.user.service
    private String daoPack = "";            //dao包, 如com.mousika.user.dao
    private String modelPack = "";          //model包, 如com.mousika.user.model
    private String serviceImplPack = "";    //serviceImpl包, 如com.mousika.user.service.impl
    private String modelField = "";         //如 usUser
    private String modelRemarks = "";       //表注释,如User表的注释, 用户
    public ServiceImplParams() {
        super();
    }
    
    
    
    public ServiceImplParams(String servicePack, String modelClass, String daoPack, String modelPack,
            String serviceImplPack, String modelField) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.daoPack = daoPack;
        this.modelPack = modelPack;
        this.serviceImplPack = serviceImplPack;
        this.modelField = modelField;
    }



    public ServiceImplParams(String servicePack, String modelClass, String daoPack, String modelPack, String serviceImplPack, String modelField, String modelRemarks) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.daoPack = daoPack;
        this.modelPack = modelPack;
        this.serviceImplPack = serviceImplPack;
        this.modelField = modelField;
        this.modelRemarks = modelRemarks;
    }



    public String getModelRemarks() {
        return modelRemarks == null ? "" : modelRemarks;
    }



    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
    }



    public String getServicePack() {
        return servicePack;
    }


    public void setServicePack(String servicePack) {
        this.servicePack = servicePack;
    }


    public String getModelClass() {
        return modelClass;
    }


    public void setModelClass(String modelClass) {
        this.modelClass = modelClass;
    }


    public String getDaoPack() {
        return daoPack;
    }


    public void setDaoPack(String daoPack) {
        this.daoPack = daoPack;
    }


    public String getModelPack() {
        return modelPack;
    }


    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }


    public String getServiceImplPack() {
        return serviceImplPack;
    }


    public void setServiceImplPack(String serviceImplPack) {
        this.serviceImplPack = serviceImplPack;
    }



    public String getModelField() {
        return modelField;
    }



    public void setModelField(String modelField) {
        this.modelField = modelField;
    }
    
    

}
