package com.mousika.velocity.params;

/**
 * service params对象
 * @author xiaojf 294825811@qq.com
 */
public class ServiceParams {
    private String packageName  = "";       //com.mousika.user.service
    private String modelName = "";          //如 User
    private String modelPack = "";          //model包, 如com.mousika.user.model
    private String modelRemarks = "";       //表注释,如User表的注释, 用户
    
    public ServiceParams() {
        super();
    }
    
    public ServiceParams(String packageName, String modelName, String modelPack, String modelRemarks) {
        super();
        this.packageName = packageName;
        this.modelName = modelName;
        this.modelPack= modelPack;
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
    public String getModelRemarks() {
        return modelRemarks == null ? "" : modelRemarks;
    }
    public void setModelRemarks(String modelRemarks) {
        this.modelRemarks = modelRemarks;
    }

    public String getModelPack() {
        return modelPack;
    }

    public void setModelPack(String modelPack) {
        this.modelPack = modelPack;
    }
    
    
}
