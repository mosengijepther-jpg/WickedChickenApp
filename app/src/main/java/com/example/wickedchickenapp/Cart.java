package com.example.wickedchickenapp;

import java.util.ArrayList;

public class Cart {
    private final ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public ArrayList<CartItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void displayCart() {
        for (CartItem item : items) {
            item.displayItem();
        }
        System.out.println("Total: K" + calculateTotal());
    }
}
