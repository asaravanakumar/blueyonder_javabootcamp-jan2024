package com.labs.spring.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfiguration {

    @Bean
    public Car swift() {
        Car swift = new Car(petrol()); // constructor injection
        swift.setModel("Swift ZXI");
        swift.setManufacturer("Maruti Suzuki");
        swift.setColor("White");
        return swift;
    }

    @Bean
    public Car bolero() {
        Car bolero = new Car();
        bolero.setModel("XUV 700");
        bolero.setManufacturer("Mahindra");
        bolero.setColor("Black");
        bolero.setEngine(diesel());
        return bolero;
    }

    @Bean
    @Primary
    public Engine petrol() {
        return new Engine("Petrol", "Manual", 1200);
    }

    @Bean
    public Engine diesel() {
        return new Engine("Diesel", "Manual", 1500);
    }

    @Bean
    public Engine electric() {
        return new Engine("Electric", "Auto", 1000);
    }

}
