package io.github.yujunchengg.okhttps.starter.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Java bean转化工具类
 * @author yujuncheng
 */
public class BeanUtil {
    /**
     * 对象转化为map
     * @param object
     * @return
     */
    public static Map<String,?> objToMap(Object object){
        Map<String,Object> map=null;
        if(null!=object){
            Class<?> aClass = object.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            if(null!=declaredFields && declaredFields.length>0){
                map=new HashMap<>();
                for(Field f:declaredFields){
                    try {
                        if("serialVersionUID".equals(f.getName())){
                            continue;
                        }
                        f.setAccessible(true);
                        map.put(f.getName(), f.get(object));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return map;
    }
}
