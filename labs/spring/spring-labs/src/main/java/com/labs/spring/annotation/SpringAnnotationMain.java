package com.labs.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringAnnotationMain {
    public static void main(String[] args) {
        // Approach #1
//        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation-config.xml");

        // Approach #2
        AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfiguration.class);

        System.out.println("No of Beans: " + ctx.getBeanDefinitionCount());

        Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);

        Car swift = ctx.getBean("swift", Car.class);
        System.out.println(swift);

        ctx.close();

    }
}
