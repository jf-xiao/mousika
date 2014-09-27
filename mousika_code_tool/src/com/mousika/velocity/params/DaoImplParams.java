package com.mousika.velocity.params;

public class DaoImplParams {

    private String servicePack;
    private String modelClass;
    private String daoPack;
    private String modelPack;
    private String serviceImplPack;
    private String modelField;
    private String daoImplPack;
    
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




    public String getDaoImplPack() {
        return daoImplPack;
    }




    public void setDaoImplPack(String daoImplPack) {
        this.daoImplPack = daoImplPack;
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
