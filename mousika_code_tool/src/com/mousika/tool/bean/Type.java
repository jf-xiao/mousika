package com.mousika.tool.bean;

public class Type {
    private String key;
    private String value;
    
    public Type() {
        super();
    }
    
    public Type(String key, String value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Type [key=" + key + ", value=" + value + "]";
    }
    
    
}
