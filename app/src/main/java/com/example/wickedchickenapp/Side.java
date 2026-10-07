package com.example.wickedchickenapp;

public class Side extends Product {
    public Side(String productName, double price) {
        super(productName, price);
    }

    // Method Overriding
    @Override
    public void displayProduct() {
        System.out.println("Side: " + productName + " - K" + price);
    }
}
