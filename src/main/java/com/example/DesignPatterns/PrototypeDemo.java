// package com.example.DesignPatterns;

// interface Prototype {
//     Prototype clone();
// }

// abstract class Shape implements Prototype {
//     protected String type;
//     private int x, y;
    
//     public Shape() {}

//     public Shape(Shape target) {
//         if (target != null) {
//             this.type = target.type;
//             this.x = target.x;
//             this.y = target.y;
//         }
//     }

//     @Override
//     public abstract Shape clone();

//     public void setPosition(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }

//     public void showInfo() {
//         System.out.println(type + " at (" + x + ", " + y + ")");
//     }
// }

// class Circle extends Shape {
//     private int radius;

//     public Circle() {
//         this.type = "Circle";
//     }

//     public Circle(Circle target) {
//         // gọi constructor của lớp cha (Shape), giúp sao chép các thuộc tính chung
//         super(target);
//         // tiếp tục sao chép các thuộc tính riêng của Circle
//         if (target != null) {
//             // lấy giá trị từ đối tượng gốc và gán giá trị đó vào đối tượng mới
//             this.radius = target.radius;
//         }
//     }

//     public void setRadius(int radius) {
//         this.radius = radius;
//     }

//     // class Circle sẽ tạo ra một đối tượng Circle mới bằng cách sử dụng constructor sao chép
//     @Override
//     public Shape clone() {
//         return new Circle(this);
//     }
// }


// class Rectangle extends Shape {
//     private int width, height;

//     public Rectangle() {
//         this.type = "Rectangle";
//     }

//     public Rectangle(Rectangle target) {
//         super(target); // gọi construtor của lớp cha (là lớp Shape)
//         // tiếp tục sao chép các thuộc tính riêng của lớp Rectangle
//         if (target != null) {
//             // lấy giá trị từ đối tượng gốc và gán giá trị đó vào đối tượng mới
//             this.width = target.width; 
//             this.height = target.height; 
//         }
//     }

//     public void setSize(int width, int height) {
//         this.width = width;
//         this.height = height;
//     }

//     // class Rectangle sẽ tạo ra một đối tượng Rectangle mới bằng cách sử dụng constructor sao chép
//     @Override
//     public Shape clone() {
//         return new Rectangle(this);
//     }
// }




// public class PrototypeDemo {
//     public static void main(String[] args) {
//         Circle originalCircle = new Circle();
//         originalCircle.setPosition(10, 20);
//         originalCircle.setRadius(15);
//         originalCircle.showInfo(); // Circle at (10, 20)

//         // Sao chép đối tượng Circle
//         Circle clonedCircle = (Circle) originalCircle.clone();
//         clonedCircle.setPosition(30, 40);
//         clonedCircle.showInfo(); // Circle at (30, 40)

//         // Tạo một đối tượng Rectangle gốc
//         Rectangle originalRectangle = new Rectangle();
//         originalRectangle.setPosition(5, 10);
//         originalRectangle.setSize(50, 100);
//         originalRectangle.showInfo(); // Rectangle at (5, 10)

//         // Sao chép đối tượng Rectangle
//         Rectangle clonedRectangle = (Rectangle) originalRectangle.clone();
//         clonedRectangle.setPosition(20, 30);
//         clonedRectangle.showInfo(); // Rectangle at (20, 30)
//     }
// }
