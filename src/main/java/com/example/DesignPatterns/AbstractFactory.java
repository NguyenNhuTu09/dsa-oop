// package com.example.DesignPatterns;


// // Giả sử chúng ta cần tạo một giao diện UI có các thành phần như Button và Checkbox.

// // Nếu ứng dụng chạy trên Windows, nó sẽ hiển thị các thành phần UI theo phong cách Windows.
// // Nếu chạy trên Mac, nó sẽ hiển thị theo phong cách macOS.
// // Để đảm bảo tính mở rộng, chúng ta sử dụng Abstract Factory Pattern.


// // Abstract Product: Button  -  Giao diện của từng loại thành phần UI (Button).
// interface Button {
//     void render();
// }

// // Concrete Product: Button cho Windows - Implement AbstractProduct theo nền tảng windows
// class WindowsButton implements Button {
//     @Override
//     public void render() {
//         System.out.println("Render Windows Button");
//     }
// }

// // Concrete Product: Button cho Mac - Implement AbstractProduct theo nền tang Mac
// class MacButton implements Button {
//     @Override
//     public void render() {
//         System.out.println("Render Mac Button");
//     }
// }

// // Abstract Product: Checkbox - Giao diện của từng loại thành phần UI (Checkbox).
// interface Checkbox {
//     void render();
// }

// // Concrete Product: Checkbox cho Windows - Implement AbstractProduct theo nền tang Windows
// class WindowsCheckbox implements Checkbox {
//     @Override
//     public void render() {
//         System.out.println("Render Windows Checkbox");
//     }
// }

// // Concrete Product: Checkbox cho Mac - Implement AbstractProduct theo nền tang Mac
// class MacCheckbox implements Checkbox {
//     @Override
//     public void render() {
//         System.out.println("Render Mac Checkbox");
//     }
// }

// // Abstract Factory: Tạo Button và Checkbox
// interface GUIFactory {
//     Button createButton();
//     Checkbox createCheckbox();
// }

// // Concrete Factory: Windows - Implement AbstractFactory để tạo các thành phần UI cho Windows
// class WindowsFactory implements GUIFactory {
//     @Override
//     public Button createButton() {
//         return new WindowsButton();
//     }

//     @Override
//     public Checkbox createCheckbox() {
//         return new WindowsCheckbox();
//     }
// }

// // Concrete Factory: Mac - Implement AbstractFactory để tạo các thành phần UI cho Mac
// class MacFactory implements GUIFactory {
//     @Override
//     public Button createButton() {
//         return new MacButton();
//     }

//     @Override
//     public Checkbox createCheckbox() {
//         return new MacCheckbox();
//     }
// }

// class Application {
//     private Button button;
//     private Checkbox checkbox;

//     // Khởi tạo Factory tùy theo nền tảng
//     public Application(GUIFactory factory) {
//         button = factory.createButton();
//         checkbox = factory.createCheckbox();
//     }

//     // Render UI
//     public void renderUI() {
//         button.render();
//         checkbox.render();
//     }
// }



// public class AbstractFactory {
//     public static void main(String[] args) {
//        // Giả sử ta xác định nền tảng là Windows
//        String os = "Windows"; // Hoặc "Mac"
//        GUIFactory factory;

//        if (os.equalsIgnoreCase("Windows")) {
//            factory = new WindowsFactory();
//        } else {
//            factory = new MacFactory();
//        }

//        // Tạo ứng dụng và hiển thị UI
//        Application app = new Application(factory);
//        app.renderUI();
//     }
// }
