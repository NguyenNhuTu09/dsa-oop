package com.example.JavaCore.Multithreading;

// cách 1 để tạo 1 thread là kế thừa từ lớp Thread
class myThread extends Thread{
    // thông thường, run là phương thức chứa logic của thread
    @Override
    public void run(){
        System.out.println("Thread is running: " + Thread.currentThread().getName());
    }
}
// cách 2 là implement từ interface Runnable
// Runnable chỉ có 1 phương thức duy nhất là run()
// Runnable là interface được thiết kế để định nghĩa task có thể chạy trong 1 thread
class myRunnable implements Runnable{
    public void run(){
        System.out.println("Runnable thread is running: " + Thread.currentThread().getName());
    }
}
public class MyThread01 {
    public static void main(String[] args) {
        myThread t1 = new myThread();
        t1.start(); // start() là phương thưucs để khởi động 1 thread mới
        // KHi gọi start() thì JVM sẽ tạo 1 luồng mới và gọi phương thức run() của đối tượng Thread đó

        Runnable r1 = new myRunnable();
        Thread t2 = new Thread(r1); // tạo 1 đối tượng Thread mới, truyền vào đối tượng Runnable
        t2.start(); // gọi start() để khởi động thread
        
    }
}
