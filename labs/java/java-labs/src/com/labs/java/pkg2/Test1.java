package com.labs.java.pkg2;

public class Test1 {
     String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected void print() {
        System.out.println("Hello " + name);
    }
}
