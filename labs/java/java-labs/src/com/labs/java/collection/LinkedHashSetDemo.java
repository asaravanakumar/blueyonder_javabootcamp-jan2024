package com.labs.java.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<Order> orders = new LinkedHashSet<>();
        Order order1 = new Order(11, "Lenovo Thinkpad", 5, 75000.0);
        Order order2 = new Order(10, "MacBook Pro", 5, 175000.0);
        Order order3 = new Order(15, "iPhone 17", 5, 80000.0);
        Order order4 = new Order(13, "Samsung Gallexy S5", 5, 95000.0);
        Order order5 = new Order(12, "HP Pavilion", 5, 85000.0);
        Order order6 = new Order(12, "HP Pavilion123", 5, 85000.0);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);

        for (Object order: orders) {
            System.out.println(order);
        }

    }
}
