# 🍗 Wicked Chicken Mobile Application

## 👥 Student Names
- **Student Name**: [Your Name / Student Name]
- **Course / Unit**: IS223 - BBIT Year 2, Semester 2

---

## 📖 Project Description
The **Wicked Chicken App** is a fully functional Android mobile application developed for Wicked Chicken fast food. It provides an intuitive, appetizing, and seamless digital ordering platform where customers can explore categorized menu items, view detailed product information and custom imagery, manage their shopping cart, complete checkout, and track past order history with PDF receipt generation and sharing capabilities.

---

## 🎯 Application Objectives
- **Digitize Ordering**: Streamline the fast-food ordering workflow from menu browsing to checkout.
- **Enhance User Experience**: Provide an eye-catching Material Design UI with rich imagery, custom product cards, and responsive system window insets.
- **Order Management**: Enable real-time cart calculation, order confirmation summaries, and past order history tracking.
- **Utility & Sharing**: Support generating downloadable PDF order receipts and sharing order details via external messaging apps.

---

## 🛠️ Development Tools
- **IDE**: Android Studio
- **Programming Language**: Java
- **UI Toolkit**: XML Layouts, Material Components, CardView, ListView
- **Version Control**: Git & GitHub
- **Build System**: Gradle

---

## ✨ Main Features
- **Splash Screen**: Branded startup introduction (`SplashActivity`).
- **Interactive Dashboard (`MainActivity`)**: Quick access to menu categories and shopping cart.
- **Category & Product Catalog**: Browse items across Burgers, BBQ Meals, Fried Meals, Seafood, Sides, Drinks, Ice Cream, and Toppers.
- **Product Details (`ProductDetailsActivity`)**: High-resolution product images, pricing, and "Add to Cart" functionality.
- **Shopping Cart & Checkout (`CartActivity` & `CheckoutActivity`)**: Manage items, calculate totals, and enter customer delivery details (Name, Phone, Address).
- **Order Confirmation & History (`OrderConfirmationActivity` & `OrderHistoryActivity`)**: Instant confirmation and persistent tracking of past orders.
- **Receipt PDF Export & Sharing (`OrderDetailsActivity`)**: Save order receipts as PDF documents or share order details via other apps.

---

## 🧱 Object-Oriented Programming (OOP) Concepts Demonstrated
This application strictly adheres to Object-Oriented Programming principles:
1. **Inheritance & Polymorphism**: 
   - `Product` acts as the base superclass.
   - Specialized subclasses (`Burger`, `ChickenMeal`, `Drink`, `Side`) inherit from `Product` and override `displayProduct()` polymorphically.
2. **Encapsulation**: 
   - Data fields (`productName`, `price`, `quantity`, `customerName`, `phone`, `address`) are encapsulated with `private`/`protected` visibility and accessed via public getter/setter methods.
3. **Abstraction & Singleton Pattern**: 
   - `CartManager` and `OrderHistoryManager` manage shared global application state (shopping cart and past orders) using static singleton patterns.

---

## 🚀 Installation & Setup Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/WickedChickenApp.git
   ```
2. **Open in Android Studio**:
   - Launch Android Studio, select **Open**, and choose the project folder.
3. **Sync Gradle**:
   - Wait for Android Studio to sync Gradle dependencies.
4. **Run the App**:
   - Connect an Android device or start an Emulator (API 24+).
   - Click the **Run** (`▶`) button.

---

## 📸 Screenshots
*(Insert your application screenshots here)*
- **Dashboard & Categories**: *[Screenshot]*
- **Product Details & Cart**: *[Screenshot]*
- **Checkout & Order History**: *[Screenshot]*
