package com.labs.java.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingDemo {
    // Anonymous Inner Class
    public static Comparator<Order> SORT_ORDER_ASC = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getId() - o2.getId();
        }
    };

    public static Comparator<Order> SORT_ORDER_DSC = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return  o2.getId() - o1.getId();
        }
    };

    public static Comparator<Order> SORT_ORDER_BY_DESC_ASC = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {
            return o1.getDescription().compareTo(o2.getDescription());
        }
    };
    public static void main(String[] args) {
//        List<String> skills = List.of("Java", "Python", "Node JS", "C");

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("C");


        Collections.sort(skills);
        System.out.println(skills);

        List orders = new ArrayList();
        Order order1 = new Order(11, "Lenovo Thinkpad", 5, 75000.0);
        Order order2 = new Order(10, "MacBook Pro", 5, 175000.0);
        Order order3 = new Order(15, "iPhone 17", 5, 80000.0);
        Order order4 = new Order(13, "Samsung Gallexy S5", 5, 95000.0);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);

//        Comparator orderComparator = new OrderCompartor();



        Collections.sort(orders, SORT_ORDER_BY_DESC_ASC);

        for (Object order: orders) {
            System.out.println(order);
        }

    }

//    static class OrderCompartor implements Comparator {
//
//        @Override
//        public int compare(Object o1, Object o2) {
//            return 0;
//        }
//    }
}
