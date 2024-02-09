package com.labs.spring.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

public abstract class Engine {
    // Petrol, Diesel, Electric
//    @Value("Petrol")
    private String type;
    // Manual, Auto
//    @Value("Manual")
    private String transType;
//    @Value("1200")
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
