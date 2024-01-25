package com.labs.java.generic;

@SuppressWarnings("all")
public class ShapeMain {
    public static void main(String[] args) {
//        Shape shape = new Shape();
//        shape.add(new Square(10));
//        System.out.println("Area is " + shape.computeArea());
//
//        Shape shape1 = new Shape();
//        shape.add(new Rectangle  (10, 20));
//        System.out.println("Area is " + shape.computeArea());

//        ShapeGeneric<Square> square = new ShapeGeneric<>();
//        square.add(new Square(10));
//        System.out.println("Area is " + square.computeArea());
//
//        ShapeGeneric<Rectangle> rectangle = new ShapeGeneric<>();
//        rectangle.add(new Rectangle  (10, 20));
//        System.out.println("Area is " + rectangle.computeArea());

        // Raw Type
        ShapeGeneric shape = new ShapeGeneric();
        shape.add(new Square(20));
        System.out.println("Area is " + shape.computeArea());
    }
}
