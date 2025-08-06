package com.example.Syntax;

import java.util.HashMap;

public class Array {
    // dịch mảng a sang phải K lần
    public static int[] solution(int[] a, int K){
        if (a.length == 0 || K % a.length == 0) return a;
        K = K % a.length;
        for(int i = 1; i <= K; i++){ 
            int temp = a[a.length - 1];
            for(int j = a.length - 1; j > 0; j--){
                a[j] = a[j - 1];
            }
            a[0] = temp;
        }
        return a;
    }

    // sử dụng 2 vòng for(độ phức tạp O(n^2)) do sử dụng 2 vòng for, không tối ưu
    public int solutionOddCurrent_1(int[]A){
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] == A[j]){
                    A[i] = 0;
                    A[j] = 0;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                result = A[i];
            }
        }
        return result;
    }
    // phiên bản cải tiến solutionOddCurrent_2
    // sử dụng HashMap và getOrDefault;
    public static int solutionOddCurrent_2(int[]A){
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int index: A){
            map.put(index, map.getOrDefault(index, 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) % 2 == 1){
                result = key;
            }
        }
        return result;
    }

    public static void SubarraySumEqualsK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void ProductofArrayExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    
    public static void main(Character[] args) {
       System.out.println("Hello, Array!");
    }
}
