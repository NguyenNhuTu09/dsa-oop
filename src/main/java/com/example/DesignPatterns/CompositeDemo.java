// package com.example.DesignPatterns;

// import java.util.ArrayList;
// import java.util.List;

// // Ví dụ: Hệ thống quản lý thư mục và tệp tin
// // Chúng ta xây dựng một hệ thống thư mục, trong đó:

// // File là một tệp tin đơn lẻ.
// // Folder có thể chứa nhiều File hoặc Folder khác.


// // Component: Giao diện chung cho File và Folder
// interface FileSystemComponent {
//     void showDetails(); // Hiển thị thông tin
// }


// // Leaf: Đối tượng đơn lẻ
// class File implements FileSystemComponent {
//     private String name;

//     public File(String name) {
//         this.name = name;
//     }

//     @Override
//     public void showDetails() {
//         System.out.println("- File: " + name);
//     }
// }


// // Composite: Chứa cả File và Folder
// class Folder implements FileSystemComponent {
//     private String name;
//     private List<FileSystemComponent> components = new ArrayList<>();

//     public Folder(String name) {
//         this.name = name;
//     }

//     public void addComponent(FileSystemComponent component) {
//         components.add(component);
//     }

//     public void removeComponent(FileSystemComponent component) {
//         components.remove(component);
//     }

//     @Override
//     public void showDetails() {
//         System.out.println("📁 Folder: " + name);
//         for (FileSystemComponent component : components) {
//             component.showDetails();
//         }
//     }
// }


// public class CompositeDemo {
//     public static void main(String[] args) {
//         // Tạo các file đơn lẻ
//         File file1 = new File("Document.pdf");
//         File file2 = new File("Image.png");
//         File file3 = new File("Video.mp4");

//         // Tạo thư mục con
//         Folder subFolder = new Folder("SubFolder");
//         subFolder.addComponent(file1);
//         subFolder.addComponent(file2);

//         // Tạo thư mục chính chứa thư mục con và một file
//         Folder mainFolder = new Folder("MainFolder");
//         mainFolder.addComponent(subFolder);
//         mainFolder.addComponent(file3);

//         // Hiển thị cấu trúc thư mục
//         mainFolder.showDetails();
//     }
// }
