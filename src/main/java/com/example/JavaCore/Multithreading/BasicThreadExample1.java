package com.example.JavaCore.Multithreading;

public class BasicThreadExample1 {
    public static int testSolutionGapBinary(int n){
        String binaryResult = Integer.toBinaryString(n);
        int solutionResult = 0;
        int localOne = -1;
        for(int i = 0; i < binaryResult.length(); i++){
            if(binaryResult.charAt(i) == '1'){
                if(localOne != 1){
                    int gap = i - localOne - 1;
                    solutionResult = Math.max(solutionResult, gap);
                }
                localOne = i;
            }
        }
        return solutionResult;
    }

    public static void main(String[] args) {
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

        int n = 529;
        int result = testSolutionGapBinary(n);
        System.out.println(result);
    }
}
