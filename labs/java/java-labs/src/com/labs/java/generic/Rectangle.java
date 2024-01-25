package com.labs.java.generic;

public class Rectangle extends BaseShape {
    private int width;
    private int breath;

    public Rectangle(int width, int breath) {
        this.width = width;
        this.breath = breath;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getBreath() {
        return breath;
    }

    public void setBreath(int breath) {
        this.breath = breath;
    }

    public int getArea() {
        return this.breath * this.width;
    }
}
