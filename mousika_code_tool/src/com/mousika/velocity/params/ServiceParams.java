package com.mousika.velocity.params;

public class ServiceParams {
    private String packageName ;
    private String modelName;
    private String modelPackage;
    private String modelRemarks;
    
    public ServiceParams() {
        super();
    }
    
    public ServiceParams(String packageName, String modelName, String modelPackage, String modelRemarks) {
        super();
        this.packageName = packageName;
        this.modelName = modelName;
        this.modelPackage = modelPackage;
        this.modelRemarks = modelRemarks;
    }

    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelPackage() {
        return modelPackage;
    }
    public void setModelPackage(String modelPackage) {
        this.modelPackage = modelPackage;
    }
    public String getModelRemarks() {
        return modelRemarks;
    }
    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
    }
    
    
}
