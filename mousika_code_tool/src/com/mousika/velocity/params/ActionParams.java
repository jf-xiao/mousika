package com.mousika.velocity.params;

/**
 * action params对象
 * @author xiaojf 294825811@qq.com
 */
public class ActionParams {

    private String servicePack = "";    //service 包,如com.mousika.user.service
    private String modelClass = "";     //model 类名,如User
    private String modelPack = "";      //model 包, 如com.mousika.user.domain
    private String modelField = "";     //如 usUser
    private String actionPack = "";     //如com.mousika.user.model
    private String modelRemarks = "";   //如User表的注释, 用户
    
    
    public ActionParams() {
        super();
    }
    
    
    
    public ActionParams(String servicePack, String modelClass, String modelPack, String modelField, String actionPack) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.modelPack = modelPack;
        this.modelField = modelField;
        this.actionPack = actionPack;
    }



    public ActionParams(String servicePack, String modelClass, String modelPack, String modelField, String actionPack, String modelRemarks) {
        super();
        this.servicePack = servicePack;
        this.modelClass = modelClass;
        this.modelPack = modelPack;
        this.modelField = modelField;
        this.actionPack = actionPack;
        this.modelRemarks = modelRemarks;
    }



    public String getModelRemarks() {
        return modelRemarks == null ? "" : modelRemarks;
    }



    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
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
    public String getModelPack() {
        return modelPack == null ? "" : modelPack;
    }
    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }
    public String getModelField() {
        return modelField == null ? "" : modelField;
    }
    public void setModelField(String modelField) {
        this.modelField = modelField;
    }
    public String getActionPack() {
        return actionPack == null ? "" : actionPack;
    }
    public void setActionPack(String actionPack) {
        this.actionPack = actionPack;
    }
    
    
}
