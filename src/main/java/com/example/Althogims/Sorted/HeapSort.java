package com.example.Althogims.Sorted;
// package com.example.Althogims;

// // ý tưởng:
// // + xây dựng Max heap từ mảng đầu vào bằng cách sử dụng thuật toán Heapify, đảm bảo phần tử lớn nhất luôn đứng đầu
// // + đưa phần từ này về cuối mảng và loại khỏi mảng (giảm kích thước Heap)
// // + tiếp tục sử dụng Heapify để loại phần tử lớn nhất dần dần ra khỏi mảng theo cách trên
// // + do phuc tap O(n^2) khong toi uu cho mang lon
// public class HeapSort {

//     public static void heapify(int[] arr, int n, int i) { 
//         int largest = i;
//         int left = 2 * i + 1; 
//         int right = 2 * i + 2; 
//         if (left < n && arr[left] > arr[largest]) { 
//             largest = left; 
//         }
//         if (right < n && arr[right] > arr[largest]) { 
//             largest = right;
//         }
//         if (largest != i) { 
//             int temp = arr[i]; 
//             arr[i] = arr[largest];
//             arr[largest] = temp;

//             heapify(arr, n, largest); 
//         }
//     }

//     public static void heapSort(int[] arr) {
//         int n = arr.length;
//         for (int i = n / 2 - 1; i >= 0; i--) {
//             heapify(arr, n, i);
//         }
//         for (int i = n - 1; i >= 1; i--) {
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;

//             heapify(arr, i, 0);
//         }
//     }

//     // Phương thức in mảng
//     public static void printArray(int[] arr) {
//         for (int i = 0; i < arr.length; ++i) {
//             System.out.print(arr[i] + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         int[] arr = {4, 10, 3, 5, 1, 99, -8, 10, 0, -8888};

//         System.out.println("Mảng ban đầu:");
//         printArray(arr);

//         heapSort(arr);

//         System.out.println("Mảng sau khi sắp xếp:");
//         printArray(arr);
//     }
// }
