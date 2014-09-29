package com.mousika.tool.bean;

/**
 * 类型
 * @author xiaojf 294825811@qq.com
 */
public class TypeInfo {
    private String key;     //key值
    private String value;   //值

    public TypeInfo() {
        super();
    }

    public TypeInfo(String key, String value) {
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
