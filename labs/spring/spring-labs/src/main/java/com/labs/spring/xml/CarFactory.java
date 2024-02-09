package com.labs.spring.xml;

public class CarFactory {

    public Car createCar() {
        System.out.println("Car Instance Factory method called...");
        return new Car();
    }

//    public Engine createPetrolEngine() {
//
//    }
//
//    public Engine createDieselEngine() {
//
//    }
//
//    public Engine createElectricEngine() {
//
//    }
}
