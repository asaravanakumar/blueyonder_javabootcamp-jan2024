package com.labs.java.generic;

public class ShapeGeneric<T extends BaseShape> {
    T shape;

    public void add(T shape) {
        this.shape = shape;
    }

    public T get() {
        return this.shape;
    }

    public double computeArea() {
//       return ((BaseShape) shape).getArea();
        return shape.getArea();
    }
}
