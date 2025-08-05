// package com.example.Althogims;

// // ý tưởng: tìm phần tử bé nhất và đưa về đầu mảng, tiếp tục với những phần tử phía 
// // độ phức tạp: O(n^2) cho trường hợp trung bình và xấu nhất
// // tiuwong tự Bubble Sort, không hiệu quả hco mảng lớn 

// public class SelectionSort {

//     // giả sử mảng ban đầu là {0, 4444, 341, 341, 7864}
//     public static void selectionSort(int[] arr) {
//         int n = arr.length; 
//         for (int i = 0; i < n - 1; i++) { 
//             int minIdx = i; // bắt đầu từ a
//             // Tìm chỉ số của phần tử nhỏ nhất trong phần chưa sắp xếp
//             for (int j = i + 1; j < n; j++) {
//                 if (arr[j] < arr[minIdx]) {
//                     minIdx = j;
//                 }
//             }
//             // Hoán đổi phần tử nhỏ nhất với phần tử đầu của phần chưa sắp xếp
//             int temp = arr[minIdx];
//             arr[minIdx] = arr[i];
//             arr[i] = temp;
//         }
//     }
//     public static void main(String[] args) {
        
//     }
// }

