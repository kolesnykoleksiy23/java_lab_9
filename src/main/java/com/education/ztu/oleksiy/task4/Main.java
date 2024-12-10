package com.education.ztu.oleksiy.task4;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try {
            Class<?> clazz = CustomAnnotation.CustomAnnotationEX.CustomClass.class;

            if (clazz.isAnnotationPresent(CustomAnnotation.class)) {
                CustomAnnotation annotation = clazz.getAnnotation(CustomAnnotation.class);
                System.out.println("Class Annotation: value = " + annotation.value() + ", priority = " + annotation.priority());
            }

            System.out.println("--- Field Annotations ---");
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(CustomAnnotation.class)) {
                    CustomAnnotation annotation = field.getAnnotation(CustomAnnotation.class);
                    System.out.println("Field: " + field.getName() + ", value = " + annotation.value() + ", priority = " + annotation.priority());
                }
            }

            System.out.println("--- Method Annotations ---");
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(CustomAnnotation.class)) {
                    CustomAnnotation annotation = method.getAnnotation(CustomAnnotation.class);
                    System.out.println("Method: " + method.getName() + ", value = " + annotation.value() + ", priority = " + annotation.priority());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
