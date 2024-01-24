package com.labs.java.collection;

import java.util.Collection;

public interface OrderService {
    public int createOrder(Order order);
    public Order getOrder(int id);
    public Collection<Order> getAllOrders();
    public boolean updateOrder(int id, Order order);
    public boolean deleteOrder(int id);
}
