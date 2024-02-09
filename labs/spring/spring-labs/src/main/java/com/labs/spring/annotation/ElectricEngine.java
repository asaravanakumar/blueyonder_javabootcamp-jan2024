package com.labs.spring.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("electric")
//@Primary
public class ElectricEngine extends Engine {
    public ElectricEngine() {
        this.setType("Electric");
        this.setTransType("Auto");
        this.setCapacity(1000);
    }
}
