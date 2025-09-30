package com.example.JavaCore.Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BasicThreadExample1 {
    public static void ThreadExp01(){
        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                System.err.println("Thread 1: " + i);
                try {
                    Thread.sleep(500);// tạm dừng 0.5 giây
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Runnable task = () -> {
            for(int i = 0; i < 5; i++){
                System.err.println("Thread 2: " + i);
                try {
                    Thread.sleep(500);// tạm dừng 0.5 giây
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
    }
    public static void ThreadExp02(){
        ExecutorService executor = Executors.newFixedThreadPool(2); // tạo ThreadPool với 2 Thread
        executor.submit(() -> {
            System.out.println("Tác vụ 1 chạy trong: " + Thread.currentThread().getName());
        });
        executor.submit(() -> {
            System.out.println("Tác vụ 2 chạy trong: " + Thread.currentThread().getName());
        });
        executor.shutdown();// đóng Thread pool sau khi hoàn thành
    }

    public static void ThreadExp03() throws InterruptedException, ExecutionException{
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<Integer> callable = () -> {
            System.out.println("Callable task is running in: " + Thread.currentThread().getName()); // gỉa lập công việc
            return 42; // trả về giá trị, điểm khác biệt so với Runnable(chỉ thực thi hàm run() mà không trả về giá trị)
        };
        Future<Integer> future = executor.submit(callable);
        System.out.println("Đang chờ kết quả....");
        if(!future.isDone()){
            System.out.println("Task chưa hoàn thành, vui lòng chờ...");
        }

        Integer result = future.get(); // chờ đến khi tác vụ hoàn thành và lấy kết quả
        System.out.println("Kết quả từ Callable: " + result);
        executor.shutdown();

    }
    public static void main(String[] args) {
        // ThreadExp01();
        // ThreadExp02(); 
        try {
            ThreadExp03();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
