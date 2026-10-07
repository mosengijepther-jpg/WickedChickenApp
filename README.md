# 🍗 Wicked Chicken Mobile Application

## 👥 Student Names
- **Student Names**: Jepther MOSENGI, Moyo PAUL & Francisca OAIKE
- **Course Name**: Business in Information Systems (BBIT) 
- **Subject Name**: Object-Oriented Programming (IS223) 
- **Year of Study**: Year 2

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

## 🖼️ Menu Image Assets & Drawable Mapping
The application includes high-resolution product and category image assets located in `app/src/main/res/drawable/`:

| Product / Category Item | Drawable Asset Filename |
| :--- | :--- |
| **App Logo** | `ic_logo.png` |
| **Chicken Fillet Burger** | `ic_chicken_fillet_burger.jpg` |
| **Classic Beef Burger** | `ic_classic_beef_burger.jpg` |
| **Double Beef & Cheese Burger** | `ic_double_beef_cheese_burger.jpg` |
| **Quick Snack BBQ Pack** | `ic_quick_bbq_pack.jpg` |
| **1/4 BBQ Pack** | `ic_quater_bbq_pack.jpg` |
| **1/2 BBQ Pack** | `ic_half_bbq_pack.jpg` |
| **BBQ & Coleslaw** | `ic_bbq_coleslaw.jpg` |
| **1/2 BBQ Chicken** | `ic_half_bbq_chicken.jpg` |
| **Whole BBQ Chicken** | `ic_whole_bbq_chicken.jpg` |
| **Fried Chicken Piece** | `ic_fried_chicken_piece.jpg` |
| **Quick Snack Fried Pack** | `ic_quick_snack_fried.jpg` |
| **Double Fried Pack** | `ic_double_fried_pack.jpg` |
| **Triple Fried Pack** | `ic_triple_fried_pack.jpg` |
| **Fried & Coleslaw** | `ic_fried_coleslaw.jpg` |
| **Seafood Basket** | `ic_seafood_basket.jpg` |
| **Hot Chips** | `ic_hot_chips.jpg` |
| **Chicken Nuggets** | `ic_chicken_nuggets.jpg` |
| **Coleslaw** | `ic_coleslaw.jpg` |
| **Mixed Vegetables** | `ic_mixed_vegetables.jpg` |
| **Chicken Gravy** | `ic_chicken_gravy.jpg` |
| **Assorted Can Drinks** | `ic_assorted_can_drinks.jpg` |
| **Pure Water 600ml** | `ic_pure_water.jpg` |
| **Sunquick Juice Cup** | `ic_sunquick.jpg` |
| **Vita Juice Drinks** | `ic_vita_juice.jpg` |
| **Slushy Cup** | `ic_slushy_cup.jpg` |
| **Soft Serve Cone** | `ic_soft_serve_cone.jpg` |
| **Soft Serve Cone (Sundae)** | `ic_soft_serve_cone_sundae.jpg` |
| **Extra Toppings** | `ic_toppings.jpg` |

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
