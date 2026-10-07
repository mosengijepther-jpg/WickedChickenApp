package com.example.wickedchickenapp;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        TextView orderSummary = findViewById(R.id.orderSummary);
        ListView orderItemsList = findViewById(R.id.orderItemsList);
        Button reorderButton = findViewById(R.id.reorderButton);
        Button shareButton = findViewById(R.id.shareButton);
        Button savePdfButton = findViewById(R.id.savePdfButton);

        int orderIndex = getIntent().getIntExtra("orderIndex", -1);
        if (orderIndex >= 0 && orderIndex < OrderHistoryManager.getPastOrders().size()) {
            Order order = OrderHistoryManager.getPastOrders().get(orderIndex);

            orderSummary.setText(String.format(Locale.US,
                    "Customer: %s\nPhone: %s\nAddress: %s\nTotal: K%.2f",
                    order.getCustomerName(), order.getPhone(), order.getAddress(), order.getTotal()));

            ArrayList<String> itemDetails = new ArrayList<>();
            for (CartItem item : order.getItems()) {
                itemDetails.add(String.format(Locale.US, "%s x%d - K%.2f",
                        item.getProduct().getName(), item.getQuantity(), item.getSubtotal()));
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    R.layout.item_list, itemDetails);
            orderItemsList.setAdapter(adapter);

            // Reorder button -> add items to current cart
            reorderButton.setOnClickListener(v -> {
                Cart cart = CartManager.getCart();
                for (CartItem item : order.getItems()) {
                    cart.addItem(item.getProduct(), item.getQuantity());
                }
                Toast.makeText(this, "Order items added to cart!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OrderDetailsActivity.this, CartActivity.class);
                startActivity(intent);
            });

            // Share button -> share order summary via Intent
            shareButton.setOnClickListener(v -> {
                StringBuilder details = new StringBuilder(orderSummary.getText().toString()).append("\n\nItems:\n");
                for (String itemStr : itemDetails) {
                    details.append("- ").append(itemStr).append("\n");
                }
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Wicked Chicken Order Details");
                shareIntent.putExtra(Intent.EXTRA_TEXT, details.toString());
                startActivity(Intent.createChooser(shareIntent, "Share Order Via"));
            });

            // Save as PDF button
            savePdfButton.setOnClickListener(v -> {
                try {
                    PdfDocument pdfDoc = new PdfDocument();
                    PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
                    PdfDocument.Page page = pdfDoc.startPage(pageInfo);

                    StringBuilder pdfContent = new StringBuilder();
                    pdfContent.append("Wicked Chicken Order Receipt\n\n");
                    pdfContent.append("Customer: ").append(order.getCustomerName()).append("\n");
                    pdfContent.append("Phone: ").append(order.getPhone()).append("\n");
                    pdfContent.append("Address: ").append(order.getAddress()).append("\n\n");
                    for (CartItem item : order.getItems()) {
                        pdfContent.append(item.getProduct().getName())
                                .append(" x").append(item.getQuantity())
                                .append(" - K").append(String.format(Locale.US, "%.2f", item.getSubtotal()))
                                .append("\n");
                    }
                    pdfContent.append("\nTotal: K").append(String.format(Locale.US, "%.2f", order.getTotal()));

                    page.getCanvas().drawText(pdfContent.toString(), 10, 25, new android.graphics.Paint());
                    pdfDoc.finishPage(page);

                    File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), "WickedChickenOrder.pdf");
                    pdfDoc.writeTo(new FileOutputStream(file));
                    pdfDoc.close();

                    Toast.makeText(this, "Order saved as PDF: " + file.getAbsolutePath(), Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    Toast.makeText(this, "Error saving PDF: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
