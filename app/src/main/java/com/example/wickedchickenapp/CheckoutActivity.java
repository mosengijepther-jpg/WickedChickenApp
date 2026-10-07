package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        EditText nameInput = findViewById(R.id.nameInput);
        EditText phoneInput = findViewById(R.id.phoneInput);
        EditText addressInput = findViewById(R.id.addressInput);
        TextView totalAmount = findViewById(R.id.totalAmount);
        Button placeOrderButton = findViewById(R.id.placeOrderButton);

        Cart cart = CartManager.getCart();
        double total = cart.calculateTotal();
        totalAmount.setText(String.format(Locale.US, "Total: K%.2f", total));

        placeOrderButton.setOnClickListener(v -> {
            String name = nameInput.getText().toString().trim();
            String phone = phoneInput.getText().toString().trim();
            String address = addressInput.getText().toString().trim();

            if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
                Toast.makeText(CheckoutActivity.this, "Please fill in all details!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save order to history
            Order order = new Order(cart.getItems(), total, name, phone, address);
            OrderHistoryManager.addOrder(order);

            // Pass details to confirmation
            Intent intent = new Intent(CheckoutActivity.this, OrderConfirmationActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("total", total);
            startActivity(intent);
            finish();
        });
    }
}
