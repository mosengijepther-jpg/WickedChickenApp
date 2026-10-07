package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView categoryListView = findViewById(R.id.categoryListView);
        Button viewHistoryButton = findViewById(R.id.viewHistoryButton);

        ArrayList<String> categories = new ArrayList<>();

        // Wicked Chicken Categories
        categories.add("Burgers & Rolls");
        categories.add("BBQ Meals");
        categories.add("Fried Meals");
        categories.add("Seafood Meals");
        categories.add("Sides");
        categories.add("Drinks");
        categories.add("Ice Cream");
        categories.add("Extra Toppers");

        // Display categories
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_list, categories);
        categoryListView.setAdapter(adapter);

        // Handle category click
        categoryListView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedCategory = categories.get(position);
            Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
            intent.putExtra("category", selectedCategory);
            startActivity(intent);
        });

        // Handle "View Past Orders" button
        viewHistoryButton.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this, OrderHistoryActivity.class);
            startActivity(intent);
        });
    }
}
