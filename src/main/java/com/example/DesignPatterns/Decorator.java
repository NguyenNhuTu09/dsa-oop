// package com.example.DesignPatterns;

// // Decorator Patterns là một mẫu thiết kế thuộc nhóm Structural Patterns. cho phép mở rộng chức năng
// // của một đối tượng mà không thay đổi cấu trúc ban đầu của lớp

// // Giả sử chúng ta có một hệ thống bán cà phê, ban đầu chỉ có cà phê cơ bản (PlainCoffee), 
// // sau đó cần thêm topping như sữa (Milk), đường (Sugar), hoặc cả hai.

// // Cách tiếp cận bằng Decorator Pattern
// // 💡 Thay vì tạo nhiều lớp như:

// // PlainCoffeeWithMilk
// // PlainCoffeeWithSugar
// // PlainCoffeeWithMilkAndSugar
// // Ta chỉ cần bọc (wrap) lớp PlainCoffee bằng các lớp Decorator (Milk, Sugar).



// // Định nghĩa interface chung - Beverage
// interface Beverage {
//     String getDescription(); // mô tả đồ uống
//     double cost(); // giá tiền
// }

// // Lớp chính cho cà phê cơ bản (Không có topping) - Concrete Component
// class PlainCoffee implements Beverage {
//     @Override
//     public String getDescription() {
//         return "Plain Coffee"; // mô tả chỉ có coffee
//     }

//     @Override
//     public double cost() {
//         return 5.0; // Nếu khách hàng không chọn topping, họ sẽ nhận được Plain Coffee ($5.0).
//     }
// }

// // Lớp Decorator chung (chứa một đối tượng Beverage) - Abstract Decorator
// // Các topping như Milk, Sugar sẽ mở rộng từ CoffeeDecorator.
// // Abstract Decorator giúp ta mở rộng chức năng mà không làm thay đổi PlainCoffee.
// abstract class CoffeeDecorator implements Beverage {
//     protected Beverage decoratedBeverage; // Giữ đối tượng gốc

//     public CoffeeDecorator(Beverage beverage) {
//         this.decoratedBeverage = beverage; // Lưu tham chiếu đến đối tượng gốc
//     }

//     @Override
//     public String getDescription() {
//         return decoratedBeverage.getDescription();  // Giữ nguyên mô tả gốc
//     }

//     @Override
//     public double cost() {
//         return decoratedBeverage.cost(); // Giữ nguyên giá gốc
//     }
// }

// // Tạo các Decorator cụ thể (Milk, Sugar)
// // Mỗi topping sẽ kế thừa CoffeeDecorator và thêm giá trị riêng.
// // Thêm sữa vào cà phê
// class Milk extends CoffeeDecorator {
//     public Milk(Beverage beverage) {
//         super(beverage);
//     }

//     @Override
//     public String getDescription() {
//         return decoratedBeverage.getDescription() + ", Milk"; // Thêm "Milk" vào mô tả
//     }

//     @Override
//     public double cost() {
//         return decoratedBeverage.cost() + 1.5; // Tăng giá lên 1.5$
//     }
// }

// // Thêm đường vào cà phê
// class Sugar extends CoffeeDecorator {
//     public Sugar(Beverage beverage) {
//         super(beverage);
//     }

//     @Override
//     public String getDescription() {
//         return decoratedBeverage.getDescription() + ", Sugar";
//     }

//     @Override
//     public double cost() {
//         return decoratedBeverage.cost() + 0.5;
//     }
// }

// public class Decorator {
//     public static void main(String[] args) {
//         Beverage coffee = new PlainCoffee();
//         System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

//         // Cà phê thêm sữa
//         coffee = new Milk(coffee);
//         System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

//         // Cà phê thêm đường
//         coffee = new Sugar(coffee);
//         System.out.println(coffee.getDescription() + " -> $" + coffee.cost());

//         // Cà phê thêm cả sữa và đường
//         coffee = new Sugar(new Milk(new PlainCoffee()));
//         System.out.println(coffee.getDescription() + " -> $" + coffee.cost());
//     }
// }
