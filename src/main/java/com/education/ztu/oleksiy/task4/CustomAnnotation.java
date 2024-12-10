package com.education.ztu.oleksiy.task4;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@interface CustomAnnotation {
    String value() default "Default Annotation Value";

    int priority() default 1;

    public class CustomAnnotationEX {
        @CustomAnnotation(value = "Class Level Annotation", priority = 3)
        public static class CustomClass {
            @CustomAnnotation(value = "Field Annotation")
            public String name;

            @CustomAnnotation(value = "Private Field Annotation", priority = 2)
            private int age;

            public CustomClass() {
                this.name = "Default Name";
                this.age = 0;
            }

            @CustomAnnotation(value = "Method Annotation")
            public void displayInfo() {
                System.out.println("Display Info Method");
            }

            @CustomAnnotation(value = "Private Method Annotation", priority = 5)
            private void secretMethod() {
                System.out.println("Secret Method Executed!");
            }
        }
    }
}
