package com.labs.spring.xml;

public class Engine {
    // Petrol, Diesel, Electric
    private String type;
    // Manual, Auto
    private String transType;
    private Integer capacity;

    public Engine() {
        System.out.println("Engine Default Constructor called...");
    }

    public Engine(String type, String transType, Integer capacity) {
        System.out.println("Engine Overloaded Constructor called...");
        this.type = type;
        this.transType = transType;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "type='" + type + '\'' +
                ", transType='" + transType + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
