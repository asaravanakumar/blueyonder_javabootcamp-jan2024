package com.labs.spring.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        // STEP 1: Add Spring Context dependency

        // STEP 2: Create IoC Container
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
        AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/beans-config.xml");
        System.out.println(ctx);

        System.out.println(ctx.getBeanDefinitionCount());

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.stream(beanNames).forEach(System.out::println);

        // STEP 3: Access/Browse the bean
        Car swift = ctx.getBean("swift", Car.class);
        System.out.println(swift); // White

//        swift.setColor("Red");
//        System.out.println(swift);  // Red
//
//        Car swift1 = ctx.getBean("swift", Car.class);
//        System.out.println(swift1); // White? Red?
//
//        swift1.setColor("Blue");
//        System.out.println(swift1);
//
//        Car swift2 = ctx.getBean("swift", Car.class);
//        System.out.println(swift2); // White? Red? Blue?

//        Car bolero = ctx.getBean("bolero", Car.class);
//        System.out.println(bolero);

        // STEP 4: Close the context - destroys all the bean
        ctx.close();

        // Throws IllegalStateException
//        Car bolero1 = ctx.getBean("bolero", Car.class);
//        System.out.println(bolero1)

    }
}
