package com.chq.project.admin.common.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 查询条件帮助类
 *
 * @author CHQ
 * @create 2018-04-28 11:20
 **/
public class SearchUtil {


    public static Map<String, Object> getSearch(Object search) {

        if (search == null) {
            return null;
        }
        Field[] fields = search.getClass().getDeclaredFields();
        Map<String, Object> searchMap = new HashMap<>();
        for (Field field : fields) {
            try {
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), search.getClass());
                Object value = propertyDescriptor.getReadMethod().invoke(search);
                if (value != null) {
                    searchMap.put(field.getName(), value);
                }
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
        return searchMap;
    }
}
