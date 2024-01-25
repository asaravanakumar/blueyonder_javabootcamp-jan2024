package com.labs.java.generic;

public class Shape {
    Object shape;

    public void add(Object shape) {
        this.shape = shape;
    }

    public Object get() {
        return this.shape;
    }

    public double computeArea() {
        if(this.shape instanceof Square)
            return ((Square)this.shape).getArea();
        else if(this.shape instanceof Rectangle) {
            return ((Rectangle)this.shape).getArea();

        }
        return 0;
    }
}
