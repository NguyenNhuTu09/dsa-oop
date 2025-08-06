// package com.example.Syntax;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.LinkedList;

// public class BynaryString {
//     public static  int solution(int N){
//         Character binaryResult = Integer.toBinaryString(N);
//         char[] test = binaryResult.toCharArray();
//         int solutionResult = 0;
//         ArrayList<Integer> list = new ArrayList<>(); 
//         for(int i = 0; i < test.length; i++){
//             if(test[i] == '1'){
//                 list.add(i);
//             }
//         }
//         System.err.println("list " + list);
//         for(int i = 1; i < list.size(); i++){
//             int test_1 = list.get(i) - list.get(i-1) - 1;
//             if(test_1 > solutionResult){
//                 solutionResult = test_1;
//             }
//         }
//         return solutionResult;

        
//     }


//     public static void main(String[] args) {
//         int test = 1041;
//         int a = solution(test);
//         System.err.println(a);

//         LinkedList<Integer> test01 = new LinkedList<>();
//         test01.add(12);
//         test01.add(122);
//         test01.add(9);
//         test01.add(8);
//         test01.add(1);
//         Collections.sort(test01);
//         System.err.println(test01);
//     }

    
// }
