package com.education.ztu.oleksiy.task3;

public class CustomClass {
    public String publicField;
    private int privateField;

    public CustomClass() {
        this.publicField = "Default";
        this.privateField = 0;
    }

    public CustomClass(String publicField, int privateField) {
        this.publicField = publicField;
        this.privateField = privateField;
    }

    public String publicMethod(String arg) {
        return "Hello, " + arg;
    }

    private void privateMethod() {
        System.out.println("Private method invoked!");
    }

    public int getPrivateField() {
        return privateField;
    }

    public void setPrivateField(int privateField) {
        this.privateField = privateField;
    }
}
