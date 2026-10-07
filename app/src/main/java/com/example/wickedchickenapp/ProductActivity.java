package com.example.wickedchickenapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ListView productListView = findViewById(R.id.productListView);
        ArrayList<Product> products = new ArrayList<>();

        String selectedCategory = getIntent().getStringExtra("category");

        if (Objects.equals(selectedCategory, "Burgers & Rolls")) {
            products.add(new Burger("Chicken Fillet Burger", 13.80));
            products.add(new Burger("Double Beef & Cheese Burger", 21.50));
            products.add(new Burger("Classic Beef Burger", 14.90));
        } else if (Objects.equals(selectedCategory, "BBQ Meals")) {
            products.add(new ChickenMeal("Quick Snack BBQ", 15.80));
            products.add(new ChickenMeal("1/4 BBQ Pack", 24.50));
            products.add(new ChickenMeal("1/2 BBQ Pack", 35.00));
            products.add(new ChickenMeal("BBQ & Coleslaw", 25.20));
            products.add(new ChickenMeal("1/2 BBQ Chicken", 23.10));
            products.add(new ChickenMeal("Whole BBQ Chicken", 43.90));
        } else if (Objects.equals(selectedCategory, "Fried Meals")) {
            products.add(new ChickenMeal("Fried Chicken Piece", 8.00));
            products.add(new ChickenMeal("Quick Snack Fried", 15.80));
            products.add(new ChickenMeal("Double Fried Pack", 24.50));
            products.add(new ChickenMeal("Triple Fried Pack", 35.00));
            products.add(new ChickenMeal("Fried & Coleslaw", 25.20));
        } else if (Objects.equals(selectedCategory, "Seafood Meals")) {
            products.add(new Product("Seafood Basket", 39.80));
        } else if (Objects.equals(selectedCategory, "Sides")) {
            products.add(new Side("Hot Chips (Reg)", 7.50));
            products.add(new Side("Hot Chips (Lge)", 12.90));
            products.add(new Side("Chicken Nuggets (4 pack)", 6.10));
            products.add(new Side("Chicken Nuggets (8 pack)", 10.90));
            products.add(new Side("Chicken Nuggets (12 pack)", 15.50));
            products.add(new Side("Coleslaw (Reg)", 3.80));
            products.add(new Side("Coleslaw (Lge)", 10.50));
            products.add(new Side("Mixed Vegetables (Reg)", 3.80));
            products.add(new Side("Mixed Vegetables (Lge)", 12.40));
            products.add(new Side("Chicken Gravy (Reg)", 2.80));
            products.add(new Side("Chicken Gravy (Lge)", 7.30));
        } else if (Objects.equals(selectedCategory, "Drinks")) {
            products.add(new Drink("Assorted Can Drinks", 3.50));
            products.add(new Drink("Pure Water 600ml", 3.50));
            products.add(new Drink("Sunquick Juice Cup", 3.30));
            products.add(new Drink("Slushy Cup", 3.50));
            products.add(new Drink("Vita Juice Drinks", 3.60));
        } else if (Objects.equals(selectedCategory, "Ice Cream")) {
            products.add(new Product("Soft Serve Cone", 4.80));
            products.add(new Product("Soft Serve Cone (Sundae)", 7.00));
        } else if (Objects.equals(selectedCategory, "Extra Toppers")) {
            products.add(new Product("Chocolate Topping", 1.20));
            products.add(new Product("Strawberry Topping", 1.20));
            products.add(new Product("Caramel Topping", 1.20));
        }

        // Display products in ListView
        ArrayList<String> productNames = new ArrayList<>();
        for (Product p : products) {
            productNames.add(String.format(Locale.US, "%s - K%.2f", p.getName(), p.getPrice()));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.item_list, productNames);
        productListView.setAdapter(adapter);

        // Open ProductDetailsActivity on tap to view image and details
        productListView.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < products.size()) {
                Product selectedProduct = products.get(position);
                Intent intent = new Intent(ProductActivity.this, ProductDetailsActivity.class);
                intent.putExtra("productName", selectedProduct.getName());
                intent.putExtra("productPrice", selectedProduct.getPrice());
                intent.putExtra("productImageRes", getProductImageRes(selectedProduct.getName()));
                startActivity(intent);
            }
        });
    }

    private int getProductImageRes(String name) {
        if (name == null) return R.mipmap.ic_launcher;
        switch (name) {
            case "Chicken Fillet Burger": return R.drawable.ic_chicken_fillet_burger;
            case "Classic Beef Burger": return R.drawable.ic_classic_beef_burger;
            case "Double Beef & Cheese Burger": return R.drawable.ic_double_beef_cheese_burger;
            case "Quick Snack BBQ": return R.drawable.ic_quick_bbq_pack;
            case "1/4 BBQ Pack": return R.drawable.ic_quater_bbq_pack;
            case "1/2 BBQ Pack": return R.drawable.ic_half_bbq_pack;
            case "BBQ & Coleslaw": return R.drawable.ic_bbq_coleslaw;
            case "1/2 BBQ Chicken": return R.drawable.ic_half_bbq_chicken;
            case "Whole BBQ Chicken": return R.drawable.ic_whole_bbq_chicken;
            case "Fried Chicken Piece": return R.drawable.ic_fried_chicken_piece;
            case "Quick Snack Fried": return R.drawable.ic_quick_snack_fried;
            case "Double Fried Pack": return R.drawable.ic_double_fried_pack;
            case "Triple Fried Pack": return R.drawable.ic_triple_fried_pack;
            case "Fried & Coleslaw": return R.drawable.ic_fried_coleslaw;
            case "Seafood Basket": return R.drawable.ic_seafood_basket;
            case "Hot Chips (Reg)":
            case "Hot Chips (Lge)": return R.drawable.ic_hot_chips;
            case "Chicken Nuggets (4 pack)":
            case "Chicken Nuggets (8 pack)":
            case "Chicken Nuggets (12 pack)": return R.drawable.ic_chicken_nuggets;
            case "Coleslaw (Reg)":
            case "Coleslaw (Lge)": return R.drawable.ic_coleslaw;
            case "Mixed Vegetables (Reg)":
            case "Mixed Vegetables (Lge)": return R.drawable.ic_mixed_vegetables;
            case "Chicken Gravy (Reg)":
            case "Chicken Gravy (Lge)": return R.drawable.ic_chicken_gravy;
            case "Assorted Can Drinks": return R.drawable.ic_assorted_can_drinks;
            case "Slushy Cup": return R.drawable.ic_slushy_cup;
            case "Pure Water 600ml": return R.drawable.ic_pure_water;
            case "Sunquick Juice Cup": return R.drawable.ic_sunquick;
            case "Vita Juice Drinks": return R.drawable.ic_vita_juice;
            case "Soft Serve Cone": return R.drawable.ic_soft_serve_cone;
            case "Soft Serve Cone (Sundae)": return R.drawable.ic_soft_serve_cone_sundae;
            case "Chocolate Topping":
            case "Strawberry Topping":
            case "Caramel Topping": return R.drawable.ic_toppings;
            default: return R.mipmap.ic_launcher;
        }
    }
}
