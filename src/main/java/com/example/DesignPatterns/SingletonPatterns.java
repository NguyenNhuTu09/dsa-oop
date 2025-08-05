// package com.example.DesignPatterns;
// // đặc điểm của singleton Pattenrn: "Chỉ cần một đối tượng để điều phối toàn bộ ứng dụng"
// // hạn chế số lượng đối tượng được tạo ra bởi một lớp


// // trong đoạn code này, lớp LoggerCustom để đảm bảo rằng chỉ có một thực thể duy nhất của lớp LoggerCustom tồn tại trong suốt
// // vòng đời ứng dụng
// class LoggerCustom{
//     private static LoggerCustom instance; // Biến instance có kiểu LoggerCustom và được khai báo là static, nghĩa là nó thuộc về lớp LoggerCustom và không thuộc về bất kỳ đối tượng cụ thể nào.
//     // Biến này được sử dụng để lưu trữ thực thể duy nhất của lớp LoggerCustom.

//     // Constructor của LoggerCustom được khai báo là private, ngăn không cho các lớp khác hoặc bất kỳ ai từ bên ngoài 
//     // tạo trực tiếp một thực thể mới của LoggerCustom.
//     // Điều này giúp kiểm soát quá trình khởi tạo và đảm bảo rằng chỉ có phương thức getInstance() 
//     // (được định nghĩa tiếp theo) mới có thể tạo ra thực thể của LoggerCustom.
//     private LoggerCustom(){}
//     public static LoggerCustom getInstance(){ // khai báo phương thức này để có thể sử dụng mà không cần khởi tạo đối tượng
//         if(instance == null){
//             instance = new LoggerCustom();
//         }
//         return instance;
//     }
//     public void log(String message){ 
//         System.err.println("Log message: " + message);
//     }
// }
// public class SingletonPatterns {
//     public static void main(String[] args) {
//         LoggerCustom logger = LoggerCustom.getInstance();
//         logger.log("Application started");
//         logger.log("An error occurred");
//     }
// }
