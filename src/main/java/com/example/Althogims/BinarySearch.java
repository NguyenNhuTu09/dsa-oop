// package com.example.Althogims;

// // tìm kiếm nhị phân
// // độ phức tạp O(logn) : Thời gian logarit , giảm kích thước bài toán theo hệ số 
// public class BinarySearch {
//     public static boolean sortArray(int a[], int n, int data){
//         int left = 0;
//         int right = n - 1;
//         while(left <= right){
//             int mid = left + (right-left)/2;
//             if(a[mid] == data){
//                 return true;
//             }
//             if(a[mid] > data){
//                 right = mid - 1;
//             }else if(a[mid] < data){
//                 left = mid + 1;
//             }
//         }
//         return false;
//     }
//     public static void main(String[] args) {
//         int a[] = {43, 444,3143,9999};
//         int data = 43;
//         if(sortArray(a, 4, data)){
//             System.err.println("Tim thay phan tu");
//         }else{
//             System.err.println("Khong tim thay phan tu");
//         }
//     }
// }
