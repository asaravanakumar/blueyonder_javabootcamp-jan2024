package com.labs.spring.xml;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Engine petrol = new Engine("Petrol", "Manual", 1200);
        Engine diesel = new Engine("Diesel", "Manual", 1500);
        Engine electric = new Engine("Electric", "Auto", 1000);

        // constructor
        Car swift = new Car("Swift VXI", "Maruti Suzuki", "Grey", diesel);

//        Car swift = new Car();
//         setters
//        swift.setColor("White");
//        swift.setModel("VXI");
//        swift.setManufacturer("Maruti Suzuki");
//        swift.setEngine(petrol);


        System.out.println(swift);

        Car bolero = new Car();
        bolero.setColor("Black");
        bolero.setModel("XYZ");
        bolero.setManufacturer("Mahendra");
        bolero.setEngine(diesel);

        System.out.println(bolero);
    }
}