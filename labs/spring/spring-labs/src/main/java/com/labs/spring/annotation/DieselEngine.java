package com.labs.spring.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("diesel")
public class DieselEngine extends Engine {

    public DieselEngine() {
        this.setType("Diesel");
        this.setTransType("Manual");
        this.setCapacity(1500);
    }

}
