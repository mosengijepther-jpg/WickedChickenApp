# 🍗 Wicked Chicken App

An Android mobile application built for **Wicked Chicken**, offering a smooth and delightful fast-food ordering experience. Customers can explore food categories, browse products with custom imagery, manage their shopping cart, place orders, and review past order history with PDF export and sharing capabilities.

---

## ✨ Features

- **Delicious Menu Catalog**: Browse categories (Burgers & Rolls, BBQ Meals, Fried Meals, Seafood Meals, Sides, Drinks, Ice Cream, Extra Toppers).
- **Product Details & Imagery**: View high-resolution product photos, descriptions, and pricing before adding items to your cart.
- **Shopping Cart & Checkout**: Real-time cart calculations, item quantities, and a sleek checkout form (Name, Phone, Delivery Address).
- **Order Confirmation & History**: Instant confirmation screen and a comprehensive past order history tracker.
- **Receipt PDF Generation & Sharing**: Export order receipts as PDF documents or share order summaries via social/messaging apps.
- **Modern Material Design UI**: Eye-catching restaurant branding featuring warm food colors (Primary Red, Accent Amber, Cream Background) with edge-to-edge system window inset support.

---

## 🛠️ Tech Stack

- **Language**: Java
- **UI Components**: Material Components, CardView, ListView, Custom List Adapters
- **Platform**: Android SDK (Min SDK 24+, Target SDK 34)
- **Build System**: Gradle

---

## 📱 App Architecture & Activities

```
com.example.wickedchickenapp/
├── SplashActivity.java        # Animated startup screen
├── MainActivity.java          # Home dashboard
├── CategoryActivity.java      # Menu categories
├── ProductActivity.java       # Product catalog per category
├── ProductDetailsActivity.java# Product detail view with images
├── CartActivity.java          # Shopping cart management
├── CheckoutActivity.java      # Customer info & order placement
├── OrderConfirmationActivity.java # Success celebration screen
├── OrderHistoryActivity.java  # Past orders list & management
└── OrderDetailsActivity.java  # Order summary, PDF export & sharing
```

---

## 🚀 Getting Started

1. Clone or download this repository.
2. Open the project in **Android Studio**.
3. Let Gradle sync project dependencies.
4. Run the app on an Android Emulator or physical device (API 24 or higher).

---

## 📄 License

This project is developed as part of academic coursework (IS223 Major Project).
