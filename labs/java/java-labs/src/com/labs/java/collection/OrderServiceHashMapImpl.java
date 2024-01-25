package com.labs.java.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class OrderServiceHashMapImpl implements OrderService {
    private Map<Integer, Order> orders = new HashMap<>();

    @Override
    public int createOrder(Order order) {
//        order.setId(orders.size() + 1);
        orders.put(order.getId(), order);
        System.out.println("com.labs.java.oops.Order Created - " + order.getId());
        return order.getId();
    }

    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }

    @Override
    public Collection<Order> getAllOrders() {
        return orders.values();
    }

    @Override
    public boolean updateOrder(int id, Order order) {
        Order ord = null;
        if(orders.containsKey(id)) {
            ord = orders.put(id, order);
        }
        return ord != null ? true : false;
    }

    @Override
    public boolean deleteOrder(int id) {
        Order ord = null;
        if(orders.containsKey(id)) {
            ord = orders.remove(id);
        }
        return ord != null ? true : false;    }
}
