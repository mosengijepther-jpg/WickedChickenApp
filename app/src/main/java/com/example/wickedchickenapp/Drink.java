package com.example.wickedchickenapp;

public class Drink extends Product {
    public Drink(String productName, double price) {
        super(productName, price);
    }

    // Method Overriding
    @Override
    public void displayProduct() {
        System.out.println("Drink: " + productName + " - K" + price);
    }
}
