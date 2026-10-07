package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OrderConfirmationActivity extends AppCompatActivity {
    private TextView confirmationMessage;
    private Button orderAgainButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        confirmationMessage = findViewById(R.id.confirmationMessage);
        orderAgainButton = findViewById(R.id.orderAgainButton);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String address = getIntent().getStringExtra("address");
        var total = getIntent().getDoubleExtra("total", 0.0);

        confirmationMessage.setText(
                "Thank you, " + name + "!\n\n" +
                        "Your order total is K" + total + ".\n" +
                        "We will deliver to: " + address + "\n" +
                        "Contact: " + phone + "\n\n" +
                        "Your Wicked Chicken order has been placed successfully!"
        );

        // Handle "Order Again" button
        orderAgainButton.setOnClickListener(v -> {
            // Clear cart for new order
            CartManager.getCart().clear();

            // Go back to CategoryActivity (main menu)
            Intent intent = new Intent(OrderConfirmationActivity.this, CategoryActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
