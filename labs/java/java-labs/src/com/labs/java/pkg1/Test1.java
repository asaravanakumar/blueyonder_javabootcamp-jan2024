package com.labs.java.pkg1;

public class Test1 {
    public static int counter;
     String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void test() {
        System.out.println("Static test method called...");
    }

    protected void print() {
        System.out.println("Hello " + name);
    }
}
