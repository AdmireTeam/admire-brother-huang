package com.abh.utils;

import com.abh.model.InputItemDTO;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ThymeleafUtils {

    public static List<InputItemDTO> model2List(Object model, Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<InputItemDTO> inputItemDTOS = new ArrayList<>();
        for (Field field : fields) {
            InputItemDTO inputItemDTO = new InputItemDTO();
            String name = field.getName();
            inputItemDTO.setId(name);
            inputItemDTO.setName(name);
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = null;
            try {
                m = clazz.getMethod("get" + name);
            } catch (NoSuchMethodException e) {
                continue;
            }
            if (m != null) {
                try {
                    inputItemDTO.setValue(String.valueOf(m.invoke(model)));
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            inputItemDTOS.add(inputItemDTO);
        }
        return inputItemDTOS;
    }

    public static String modelDumps(Object model, Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        String result = "";
        for (Field field : fields) {
            String name = field.getName();
            result += (name + ":");
            name = name.substring(0, 1).toUpperCase() + name.substring(1);
            Method m = null;
            try {
                m = clazz.getMethod("get" + name);
            } catch (NoSuchMethodException e) {
                continue;
            }
            if (m != null) {
                try {
                    result += (String.valueOf(m.invoke(model)) + ", ");
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
