package com.labs.java.collection;

import java.util.Collection;

public class OrderMain {
    public static void main(String[] args) {

        OrderService orderService = new OrderServiceHashMapImpl();

        // TODO: Logic to perform com.labs.java.oops.Order CRUD operations
        // Create com.labs.java.oops.Order
        Order order1 = new Order(11, "Lenovo Thinkpad", 5, 75000.0);
        Order order2 = new Order(10, "MacBook Pro", 5, 175000.0);
        Order order3 = new Order(15, "iPhone 17", 5, 80000.0);
        Order order4 = new Order(13, "Samsung Gallexy S5", 5, 95000.0);

        System.out.println("Create Orders...");
        orderService.createOrder(order1);
        orderService.createOrder(order2);
        orderService.createOrder(order3);
        orderService.createOrder(order4);

        // List Orders
        System.out.println("List Orders...");
        Collection<Order> orders = orderService.getAllOrders();
        for (Order order: orders) {
            System.out.println(order);
        }

        // View com.labs.java.oops.Order
        System.out.println("View com.labs.java.oops.Order");
        Order order = orderService.getOrder(10);
        System.out.println(order);

        // Update com.labs.java.oops.Order
        System.out.println("Update com.labs.java.oops.Order");
        order2.setPrice(65000);
        orderService.updateOrder(10, order2);
        System.out.println(orderService.getOrder(10));

        // Delete com.labs.java.oops.Order
        System.out.println("Delete com.labs.java.oops.Order");
        orderService.deleteOrder(10);

        // List Orders
        for (Order ord: orderService.getAllOrders()) {
            System.out.println(ord);
        }

        // Statistics
        // Get Total Quantity
        // Get Min, Max, Avg Price
        // Get Product wise Count

        // iPhone 17 - 5
        // Lenovo ThinkPad - 3
    }
}
