package com.example.wickedchickenapp;
public class Burger extends Product {
    public Burger(String productName, double price) {
        super(productName, price);
    }

    // Method Overriding
    @Override
    public void displayProduct() {
        System.out.println("Burger: " + productName + " - K" + price);
    }
}