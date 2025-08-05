package com.example.Syntax;

import java.util.HashMap;

public class Array {
    // dịch mảng a sang phải K lần
    public static int[] solution(int[] a, int K){
        int n = a.length;
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

    // cho 1 mảng số nguyên A
    // trả về một mảng số là các phần tử của A chưa từng lặp lại tại mỗi
    // thời điểm khi duyệt từ trái sang phải
    // nếu phần tử đó đã từng lặp lại, trả về -1
    public static int[] solutionTask01ChatGPT(int []A){

        return A;
    }
    
    public static void main(String[] args) {
       
        
    }
}
