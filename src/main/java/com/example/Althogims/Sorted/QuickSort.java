package com.example.Althogims.Sorted;
// package com.example.Althogims;

// // thuật toán dựa tren phương pháp chia để trị
// // lựa chọn một phần tử trong mảng làm điểm chốt(pivot), sau đó sắp xếp lại mảng sao 
// // cho tất cả
// // phần tử nhỏ hơn điểm chốt nằm trên trái chốt, còn lớn hơn nằm bên phải
// public class QuickSort {

//     // Hàm phân hoạch (partition) cho QuickSort
//     // chọn phần tử cuối của mảng làm pivot
//     // sắp xếp lại mảng sao cho các phần tử nhỏ hơn pivot nằm bên trái và phần tử 
//     // lơn hơn nằm bên hảphair
//     // trả về vị ví chính xác của pivot sau khi sắp xếp
//     // 
//     public static int partition(int[] arr, int low, int high) {
//         int pivot = arr[high]; // Chọn phần tử cuối làm pivot
//         int i = low - 1; // Chỉ số của phần tử nhỏ hơn pivot

//         for (int j = low; j < high; j++) {
//             if (arr[j] < pivot) {
//                 i++;
//                 // Hoán đổi arr[i] và arr[j]
//                 int temp = arr[i];
//                 arr[i] = arr[j];
//                 arr[j] = temp;
//             }
//         }
//         // Đặt pivot vào đúng vị trí
//         int temp = arr[i + 1];
//         arr[i + 1] = arr[high];
//         arr[high] = temp;

//         return i + 1; // Trả về vị trí của pivot
//     }

//     // Hàm QuickSort đệ quy
//     // Gọi đệ quy quickSort cho hai phần của mảng nằm bên trái và bên phải của pivot.
//     // Mỗi phần của mảng sẽ được sắp xếp cho đến khi mảng chỉ còn một phần tử.

//     public static void quickSort(int[] arr, int low, int high) {
//         if (low < high) {
//             // Tìm vị trí của pivot
//             int pi = partition(arr, low, high);

//             // Đệ quy sắp xếp các phần của mảng bên trái và bên phải pivot
//             quickSort(arr, low, pi - 1);
//             quickSort(arr, pi + 1, high);
//         }
//     }

//     // Hàm main để chạy thử thuật toán QuickSort
//     public static void main(String[] args) {
//         int[] arr = {10, 7, 8, 9, 1, 5};
//         int n = arr.length;

//         quickSort(arr, 0, n - 1);

//         System.out.println("Mảng sau khi sắp xếp: ");
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }

