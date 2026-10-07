package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;

public class OrderHistoryActivity extends AppCompatActivity {
    private ArrayAdapter<String> adapter;
    private ArrayList<Order> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        ListView historyListView = findViewById(R.id.historyListView);
        Button clearHistoryButton = findViewById(R.id.clearHistoryButton);

        ArrayList<String> historyItems = new ArrayList<>();
        orders = OrderHistoryManager.getPastOrders();

        for (Order order : orders) {
            historyItems.add(String.format(Locale.US, "%s - K%.2f\nItems: %d | Phone: %s",
                    order.getCustomerName(), order.getTotal(), order.getItems().size(), order.getPhone()));
        }

        adapter = new ArrayAdapter<>(this,
                R.layout.item_list, historyItems);
        historyListView.setAdapter(adapter);

        // Tap order -> View details
        historyListView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(OrderHistoryActivity.this, OrderDetailsActivity.class);
            intent.putExtra("orderIndex", position);
            startActivity(intent);
        });

        // Clear history with confirmation dialog
        clearHistoryButton.setOnClickListener(v -> new android.app.AlertDialog.Builder(OrderHistoryActivity.this)
                .setTitle("Delete History")
                .setMessage("Are you sure you want to clear all past orders?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    OrderHistoryManager.clearHistory();
                    adapter.clear();
                    adapter.notifyDataSetChanged();
                    Toast.makeText(OrderHistoryActivity.this,
                            "Order history cleared!", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("No", (dialog, which) -> dialog.dismiss())
                .show());
    }
}
