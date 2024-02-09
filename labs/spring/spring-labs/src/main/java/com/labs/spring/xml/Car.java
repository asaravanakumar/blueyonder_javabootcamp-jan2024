package com.labs.spring.xml;

public class Car {

    private static Car car;

    private String model;
    private String manufacturer;
    private String color;
    private Engine engine;

    public Car() {
//        this.engine = new Engine("Diesel", "Manual", 1500);
        System.out.println("Car Default constructor called..");
    }

    public Car(Engine engine) {
        System.out.println("Car Overloaded constructor with Engine called...");
        this.engine = engine;
    }

    public Car(String model, String manufacturer, String color, Engine engine) {
        System.out.println("Car Overloaded constructor called..");
        this.model = model;
        this.manufacturer = manufacturer;
        this.color = color;
        this.engine = engine;
    }

    public void init() {
        System.out.println("Car Init Method called...");
    }

    public void destroy() {
        System.out.println("Car Destroy Method called...");
    }


    public static Car getInstance() {
        System.out.println("Car Default Factory Method");
        // sigleton
        if(car == null) {
            car = new Car();
        }
        return car;
    }

    public static Car getInstance(String model, String manufacturer, String color, Engine engine) {
        System.out.println("Car Overloaded Factory Method");
        // sigleton
        if(car == null) {
            car = new Car(model, manufacturer, color, engine);
        }
        return car;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }
}
