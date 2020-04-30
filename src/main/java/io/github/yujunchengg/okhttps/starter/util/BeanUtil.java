package io.github.yujunchengg.okhttps.starter.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
public class BeanUtil {
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
