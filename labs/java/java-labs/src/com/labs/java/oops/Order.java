package com.labs.java.oops;

public class Order implements Cloneable{
    private int id;
    private String description;
    private int quantity;
    private double price;

    public Order() {

    }

    public Order(int id, String description, int quantity, double price) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Order) {
            Order order = (Order) obj;
            return this.getId() == order.getId();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId() % 5;
    }

    @Override
    public Object clone() {
        return this;
    }

    @Override
    public String toString() {
        return "com.labs.java.oops.Order{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
