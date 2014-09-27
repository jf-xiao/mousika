package com.mousika.tool.bean;

public class TemplateConfigInfo {
    private String packageStr;
    private String templatePath;
    private boolean isEnable;
    
    public TemplateConfigInfo() {
        super();
    }
    
    public TemplateConfigInfo(String packageStr, String templatePath, boolean isEnable) {
        super();
        this.packageStr = packageStr;
        this.templatePath = templatePath;
        this.isEnable = isEnable;
    }
    
    

    @Override
    public String toString() {
        return "TemplateConfigInfo [packageStr=" + packageStr + ", templatePath=" + templatePath + ", isEnable="
                + isEnable + "]";
    }

    public String getPackageStr() {
        return packageStr;
    }
    public void setPackageStr(String packageStr) {
        this.packageStr = packageStr;
    }
    public String getTemplatePath() {
        return templatePath;
    }
    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }
    public boolean isEnable() {
        return isEnable;
    }
    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }
    
    
}
