package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        ListView cartListView = findViewById(R.id.cartListView);
        TextView cartTotal = findViewById(R.id.cartTotal);
        Button checkoutButton = findViewById(R.id.checkoutButton);
        Button clearCartButton = findViewById(R.id.clearCartButton);

        Cart cart = CartManager.getCart();

        // Display cart items
        ArrayList<String> cartItems = new ArrayList<>();
        for (CartItem item : cart.getItems()) {
            cartItems.add(String.format(Locale.US, "%s x%d - K%.2f",
                    item.getProduct().getName(), item.getQuantity(), item.getSubtotal()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_list, cartItems);
        cartListView.setAdapter(adapter);

        // Display total
        cartTotal.setText(String.format(Locale.US, "Total: K%.2f", cart.calculateTotal()));

        // Checkout button -> go to CheckoutActivity
        checkoutButton.setOnClickListener(v -> {
            if (cart.getItems().isEmpty()) {
                Toast.makeText(CartActivity.this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(CartActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

        // Clear Cart button -> reset cart
        clearCartButton.setOnClickListener(v -> {
            cart.clear(); // clear all items
            Toast.makeText(CartActivity.this, "Cart cleared!", Toast.LENGTH_SHORT).show();

            // Refresh UI
            adapter.clear();
            cartTotal.setText(getString(R.string.cart_total_default));
        });
    }
}
