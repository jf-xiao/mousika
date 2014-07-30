package com.mousika.common.util;

import java.util.Collection;

public class EmptyUtil {
    /**
     * 为空判断
     * @param obj 判断对象
     * @return true:为空,false:不为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj != null) {                                  // 判断是否为null
            if (obj instanceof String) {                    // 判断是否为String字符串
                String str = obj.toString();
                if (str.trim().length() > 0) {              // 字符串长度不为0
                    return false;
                } else {                                    // 字符传长度为0
                    return true;
                }
            } else {                                        // 不是字符串
                if (obj instanceof Collection) {            // 弱是数组类型
                    if(((Collection)obj).size() <= 0){
                        return true ;                       //为空
                    }else{
                        return false ;                      //不为空
                    }
                }else{
                    return false;                           //不为空
                }
            }
        } else {                                            // 是null
            return true;
        }
    }
    
    /**
     * 不为空判断
     * @param obj 判断对象
     * @return true:不为空,false:为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }
}
