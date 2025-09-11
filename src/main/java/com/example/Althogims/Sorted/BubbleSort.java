package com.example.Althogims.Sorted;
// package com.example.Althogims;

// // ý tưởng: so sánh các phần tử liền kề, hoán đổi chúng nếu không theo thứ tự 
// // độ phức tạp O(n^2) cho trường hợp xấu nhất và trung bình
// // tăng theo bình phương khi kích thước dầu ào lớn

// public class BubbleSort {
//     public static void sortArr(int arr[]){
//         int n = arr.length;
//         for(int i = 0; i < n - 1; i++){
//             for(int j = 0; j < n - i - 1; j++){
//                 if(arr[j] > arr[j + 1]){
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }
//             }
//         }
//     }
//     public static void display(int arr[]){
//         for(int i = 0; i < arr.length; i++){
//             System.out.print(arr[i] + " ");
//         }
//     }
//     public static void main(String[] args) {
//         int arr[] = {12, -908, 343, 134, 0, -13413434, 98, 89};
//         sortArr(arr);
//         display(arr);
//     }
// }
