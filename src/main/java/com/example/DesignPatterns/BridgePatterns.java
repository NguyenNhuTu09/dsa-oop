// package com.example.DesignPatterns;


// // Xây dựng một hệ thống vẽ hình (Circle, Square, Triangle)
// // Mỗi hình có thể được vẽ với nhiều màu sắc khác nhau (Red, Blue, Green,...).
// // Nếu không dùng Bridge Pattern, ta sẽ có rất nhiều lớp kết hợp giữa hình và màu, như:
// // RedCircle, BlueCircle, GreenCircle
// // RedSquare, BlueSquare, GreenSquare
// // RedTriangle, BlueTriangle, GreenTriangle
// // Sự kết hợp này gây bùng nổ số lượng lớp (Class Explosion), làm hệ thống khó bảo trì và mở rộng.
// // 🔴 Giải pháp: Dùng Bridge Pattern
// // Chúng ta tách màu sắc và hình dạng thành hai hệ thống độc lập:

// // Abstraction: Shape (Hình dạng)
// // Implementation: Color (Màu sắc)

// // Implementor: Định nghĩa giao diện màu sắc
// interface Color {
//     void applyColor();
// }

// // Concrete Implementor 1: Màu đỏ
// class RedColor implements Color {
//     @Override
//     public void applyColor() {
//         System.out.println("Applying red color");
//     }
// }

// // Concrete Implementor 2: Màu xanh
// class BlueColor implements Color {
//     @Override
//     public void applyColor() {
//         System.out.println("Applying blue color");
//     }
// }

// // Abstraction: Hình dạng
// abstract class Shape {
//     protected Color color;

//     public Shape(Color color) {
//         this.color = color;
//     }

//     abstract void draw();
// }

// // Refined Abstraction: Hình tròn
// class Circle extends Shape {
//     public Circle(Color color) {
//         super(color);
//     }

//     @Override
//     void draw() {
//         System.out.print("Drawing Circle with ");
//         color.applyColor();
//     }
// }

// // Refined Abstraction: Hình vuông
// class Square extends Shape {
//     public Square(Color color) {
//         super(color);
//     }

//     @Override
//     void draw() {
//         System.out.print("Drawing Square with ");
//         color.applyColor();
//     }
// }

// public class BridgePatterns {
//     public static void main(String[] args) {
//         Shape redCircle = new Circle(new RedColor());
//         Shape blueSquare = new Square(new BlueColor());

//         redCircle.draw();  // Output: Drawing Circle with Applying red color
//         blueSquare.draw(); // Output: Drawing Square with Applying blue color
//     }
// }
