package com.labs.java.oops;

public class OrderMain {
    public static void main(String[] args) {
        Order order1 = new Order(11, "Lenovo Thinkpad", 5, 75000.0);

        System.out.println(order1);

        Order order2 = new Order(12, "Lenovo Thinkpad", 5, 75000.0);

//        com.labs.java.oops.Order order2 = order1;

        System.out.println(order2);

        System.out.println("order1 == order2 " + (order1 == order2));  // false
        System.out.println("order1.equals(order2) " + order1.equals(order2)); // true?

        System.out.println("order1 " + order1.hashCode());
        System.out.println("order2 " + order2.hashCode());

        Order order3 = (Order) order1.clone();
        System.out.println(order3);
    }
}
