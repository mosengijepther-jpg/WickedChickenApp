package com.example.wickedchickenapp;

import java.util.ArrayList;

public class Order {
    private ArrayList<CartItem> items;
    private double total;
    private String customerName;
    private String phone;
    private String address;

    public Order(ArrayList<CartItem> items, double total, String customerName, String phone, String address) {
        this.items = items;
        this.total = total;
        this.customerName = customerName;
        this.phone = phone;
        this.address = address;
    }

    public ArrayList<CartItem> getItems() { return items; }
    public double getTotal() { return total; }
    public String getCustomerName() { return customerName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }
}
