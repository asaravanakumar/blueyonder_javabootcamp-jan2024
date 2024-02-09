package com.labs.spring.annotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("petrol")
public class PetrolEngine extends Engine{
    public PetrolEngine() {
        this.setType("Petrol");
        this.setTransType("Manual");
        this.setCapacity(1200);
    }
}
