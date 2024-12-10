package com.education.ztu.oleksiy.task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class<?> clazz1 = CustomClass.class;
            Class<?> clazz2 = new CustomClass().getClass();
            Class<?> clazz3 = Class.forName("com.education.ztu.oleksiy.task3.CustomClass");


            System.out.println("--- Fields ---");
            for (Field field : clazz1.getDeclaredFields()) {
                System.out.println("Name: " + field.getName() + ", Type: " + field.getType());
            }

            System.out.println("--- Methods ---");
            for (Method method : clazz1.getDeclaredMethods()) {
                System.out.print("Name: " + method.getName() + ", Return type: " + method.getReturnType());
                System.out.print(", Parameter types: ");
                for (Class<?> paramType : method.getParameterTypes()) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            System.out.println("--- Constructors ---");
            for (Constructor<?> constructor : clazz1.getDeclaredConstructors()) {
                System.out.print("Parameter types: ");
                for (Class<?> paramType : constructor.getParameterTypes()) {
                    System.out.print(paramType.getName() + " ");
                }
                System.out.println();
            }

            Object instance = clazz1.getConstructor(String.class, int.class).newInstance("Custom Value", 42);


            Method publicMethod = clazz1.getMethod("publicMethod", String.class);
            Object result = publicMethod.invoke(instance, "Reflection API");
            System.out.println("Result of publicMethod: " + result);

            Field privateField = clazz1.getDeclaredField("privateField");
            privateField.setAccessible(true);
            privateField.set(instance, 100);
            System.out.println("Updated privateField value: " + privateField.get(instance));

            Method privateMethod = clazz1.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(instance);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}