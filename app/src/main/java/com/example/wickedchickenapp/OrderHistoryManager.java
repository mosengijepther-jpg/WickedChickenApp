package com.example.wickedchickenapp;

import java.util.ArrayList;

public class OrderHistoryManager {
    private static final ArrayList<Order> pastOrders = new ArrayList<>();

    public static void addOrder(Order order) {
        pastOrders.add(order);
    }

    public static ArrayList<Order> getPastOrders() {
        return pastOrders;
    }

    public static void clearHistory() {
        pastOrders.clear();
    }
}
