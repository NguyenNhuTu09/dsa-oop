// package com.example.DesignPatterns;


// // Giả sử chúng ta cần tạo giao diện Button, nhưng thay vì sử dụng một Factory tổng quát như Abstract Factory, ta chỉ cần một phương thức để tạo ra đối tượng phù hợp.

// // Nếu ứng dụng chạy trên Windows, nó sẽ hiển thị một Windows Button.
// // Nếu chạy trên Mac, nó sẽ hiển thị một Mac Button.
// // Chúng ta sẽ sử dụng Factory Method Pattern để tách biệt logic tạo button ra khỏi phần logic chính của ứng dụng.


// // Product: Giao diện Button chung - Giao diện hoặc lớp cha của đối tượng cần tạo (Button).
// interface Button {
//     void render();
// }
// // Concrete Product: Windows Button -  Implement Product theo từng loại cụ thể (WindowsButton).
// class WindowsButton implements Button {
//     @Override
//     public void render() {
//         System.out.println("Render Windows Button");
//     }
// }

// // Concrete Product: Mac Button -  Implement Product theo từng loại cụ thể (MacButton).
// class MacButton implements Button {
//     @Override
//     public void render() {
//         System.out.println("Render Mac Button");
//     }
// }


// // Creator (Factory Method) - Lớp chứa phương thức factory method để tạo Product.
// abstract class Dialog {
//     // Factory Method: Định nghĩa phương thức tạo button (từng subclass sẽ override)
//     abstract Button createButton();

//     // Logic sử dụng button (chung cho mọi loại dialog)
//     public void renderDialog() {
//         Button button = createButton();
//         button.render();
//     }
// }


// // Concrete Creator: Windows Dialog - Implement factory method để trả về ConcreteProduct phù hợp.
// class WindowsDialog extends Dialog {
//     @Override
//     Button createButton() {
//         return new WindowsButton();
//     }
// }

// // Concrete Creator: Mac Dialog - Implement factory method để trả về ConcreteProduct phù hợp.
// class MacDialog extends Dialog {
//     @Override
//     Button createButton() {
//         return new MacButton();
//     }
// }





// public class FactoryMethods {
//     public static void main(String[] args) {
//         Dialog dialog;

//         // Xác định hệ điều hành
//         String os = "Windows"; // Hoặc "Mac"

//         if (os.equalsIgnoreCase("Windows")) {
//             dialog = new WindowsDialog();
//         } else {
//             dialog = new MacDialog();
//         }

//         // Render Dialog (tự động tạo button phù hợp)
//         dialog.renderDialog();
//     }
// }
