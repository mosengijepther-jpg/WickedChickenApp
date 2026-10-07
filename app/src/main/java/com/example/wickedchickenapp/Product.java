package com.example.wickedchickenapp;

public class Product {
    protected String productName;
    protected double price;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    // Method
    public void displayProduct() {
        System.out.println(productName + " - K" + price);
    }

    // Getters and Setters
    public String getProductName() {
        return productName;
    }

    public String getName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
