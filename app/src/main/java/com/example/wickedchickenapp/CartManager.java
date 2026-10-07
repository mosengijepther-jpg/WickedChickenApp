package com.example.wickedchickenapp;

public class CartManager {
    private static Cart cartInstance;

    // Private constructor prevents direct instantiation
    private CartManager() { }

    // Get the shared Cart instance
    public static Cart getCart() {
        if (cartInstance == null) {
            cartInstance = new Cart();
        }
        return cartInstance;
    }

    // Reset cart if needed (e.g., after order confirmation)
    public static void clearCart() {
        cartInstance = new Cart();
    }
}
