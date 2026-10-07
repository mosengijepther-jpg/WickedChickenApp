package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // links to activity_main.xml

        Button viewCategoriesButton = findViewById(R.id.viewCategoriesButton);
        Button viewCartButton = findViewById(R.id.viewCartButton);

        // Navigate to CategoryActivity
        viewCategoriesButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            startActivity(intent);
        });

        // Navigate to CartActivity
        viewCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }
}
