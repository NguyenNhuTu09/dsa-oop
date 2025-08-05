// package com.example.DesignPatterns;

// // Target Interface: Định nghĩa giao diện mà hẹ thống đang sử dụng
// interface MediaPlayer {
//     void play(String audioType, String fileName);
// }

// // Adaptee Class: Đối tượng cần thích nghi , là lớp hoặc giao diện không tương thích cần được thích nghi để sử dụng trong hệ thống
// class AdvancedMediaPlayer {
//     void playMp4(String fileName) {
//         System.out.println("Playing mp4 file: " + fileName);
//     }
// }

// // Adapter Class: lớp trung gian để chuyển đổi giao diện của Adaptee thành Targe để hệ thống có thể sử dụng Adaptee mà không gặp lỗi
// class MediaAdapter implements MediaPlayer {
//     private AdvancedMediaPlayer advancedMediaPlayer;

//     public MediaAdapter() {
//         advancedMediaPlayer = new AdvancedMediaPlayer();
//     }

//     @Override
//     public void play(String audioType, String fileName) {
//         if (audioType.equalsIgnoreCase("mp4")) { // method equalsIgnoreCase dùng để so sánh 2 chuỗi với nhau (không phân biệt hoa và thường), trả về true nêus bằng
//             advancedMediaPlayer.playMp4(fileName);
//         } else {
//             System.out.println("Unsupported audio type: " + audioType);
//         }
//     }
// }


// public class AdapterPaterns {
//     public static void main(String[] args) {
//         MediaPlayer player = new MediaAdapter();
//         player.play("mp4", "video_example.mp4");
//     }
// }
