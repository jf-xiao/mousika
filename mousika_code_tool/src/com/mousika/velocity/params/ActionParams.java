package com.mousika.velocity.params;

public class ActionParams {

    private String servicePack;
    private String modelClass;
    private String modelPack;
    private String modelField;
    private String actionPack;
    
    
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
    public String getModelPack() {
        return modelPack;
    }
    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }
    public String getModelField() {
        return modelField;
    }
    public void setModelField(String modelField) {
        this.modelField = modelField;
    }
    public String getActionPack() {
        return actionPack;
    }
    public void setActionPack(String actionPack) {
        this.actionPack = actionPack;
    }
    
    
}
