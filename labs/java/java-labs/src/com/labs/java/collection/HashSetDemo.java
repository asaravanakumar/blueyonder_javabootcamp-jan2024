package com.labs.java.collection;

import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
//        Set<String> skills = new HashSet<>();
//        skills.add("Java");
//        skills.add("PHP");
//        skills.add("Python");
//        skills.add("Java");
//        skills.add(null);
//        skills.add(null);
//
//        System.out.println(skills.contains("Java"));
//        System.out.println(skills);

        Set<Order> orders = new HashSet<>();
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

//        List<Order> orderList = new ArrayList<Order>(orders);
//
//        Collections.sort(orderList, SortingDemo.SORT_ORDER_ASC);

//        for (Object order: orderList) {
//            System.out.println(order);
//        }
    }
}
