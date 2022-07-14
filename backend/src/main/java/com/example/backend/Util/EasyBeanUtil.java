package com.example.backend.Util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EasyBeanUtil {
    /*
     * 关于Java类(Bean)的一些工具函数
     * */

    public static Map beanToMap(Object object) throws IllegalAccessException {
        /*
        * 将Java实体类中已声明的属性转换成Map映射
        * */
        Map<String, Object> map = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(object));
        }

        return map;
    }
}
