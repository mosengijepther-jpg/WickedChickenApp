package com.example.wickedchickenapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class ProductDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Cart cart = CartManager.getCart();

        TextView productName = findViewById(R.id.productName);
        TextView productPrice = findViewById(R.id.productPrice);
        ImageView productImage = findViewById(R.id.productImage);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        // Get product info from intent
        String name = getIntent().getStringExtra("productName");
        double price = getIntent().getDoubleExtra("productPrice", 0.0);
        int imageRes = getIntent().getIntExtra("productImageRes", R.mipmap.ic_launcher);

        if (name != null) {
            productName.setText(name);
        }
        productPrice.setText(String.format(Locale.US, "K%.2f", price));
        productImage.setImageResource(imageRes);

        // Add to cart logic
        addToCartButton.setOnClickListener(v -> {
            if (name != null) {
                Product product = new Product(name, price);
                cart.addItem(product, 1);
                Toast.makeText(ProductDetailsActivity.this,
                        name + " added to cart!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
