// package com.example.Althogims;
// // Merge Sort là một thuật toán sắp xếp dựa trên phương pháp "chia để trị" (divide and conquer). Ý 
// // tưởng chính của thuật toán là chia mảng ban đầu thành hai mảng con, sắp xếp các mảng con đó, 
// // sau đó hợp nhất (merge) chúng lại thành mảng đã sắp xếp.
// // Bước 1: Nếu mảng có ít hơn hai phần tử, thì nó đã được sắp xếp (vì không cần thao tác gì thêm).
// // Bước 2: Chia mảng thành hai mảng con.
// // Bước 3: Áp dụng đệ quy Merge Sort cho hai mảng con.
// // Bước 4: Sau khi hai mảng con đã được sắp xếp, hợp nhất chúng lại sao cho mảng con trái và mảng con phải 
// // sẽ được hợp nhất theo thứ tự tăng dần.
// // Độ phức tạp thời gian ổn định: Độ phức tạp thời gian của Merge Sort là 𝑂(𝑛log𝑛)
// // O(nlogn) trong mọi trường hợp (tốt nhất, trung bình, và xấu nhất), nên nó hoạt động rất ổn định với các dữ liệu lớn.
// public class MergeSort {

//     // Hàm để hợp nhất hai mảng con đã được sắp xếp
//     public static void merge(int[] arr, int left, int mid, int right) {
//         int n1 = mid - left + 1; // Số phần tử trong mảng con trái
//         int n2 = right - mid;    // Số phần tử trong mảng con phải

//         // Tạo mảng con tạm thời
//         int[] leftArr = new int[n1];
//         int[] rightArr = new int[n2];

//         // Sao chép dữ liệu vào các mảng con tạm thời
//         for (int i = 0; i < n1; i++)
//             leftArr[i] = arr[left + i];
//         for (int j = 0; j < n2; j++)
//             rightArr[j] = arr[mid + 1 + j];

//         // Hợp nhất các mảng con
//         int i = 0, j = 0, k = left;
//         while (i < n1 && j < n2) {
//             if (leftArr[i] <= rightArr[j]) {
//                 arr[k] = leftArr[i];
//                 i++;
//             } else {
//                 arr[k] = rightArr[j];
//                 j++;
//             }
//             k++;
//         }

//         // Sao chép các phần tử còn lại của leftArr nếu có
//         while (i < n1) {
//             arr[k] = leftArr[i];
//             i++;
//             k++;
//         }

//         // Sao chép các phần tử còn lại của rightArr nếu có
//         while (j < n2) {
//             arr[k] = rightArr[j];
//             j++;
//             k++;
//         }
//     }

//     // Hàm Merge Sort đệ quy
//     public static void mergeSort(int[] arr, int left, int right) {
//         if (left < right) {
//             int mid = left + (right - left) / 2;

//             // Sắp xếp nửa bên trái
//             mergeSort(arr, left, mid);

//             // Sắp xếp nửa bên phải
//             mergeSort(arr, mid + 1, right);

//             // Hợp nhất các nửa đã sắp xếp
//             merge(arr, left, mid, right);
//         }
//     }

//     // Hàm main để chạy thử thuật toán Merge Sort
//     public static void main(String[] args) {
//         int[] arr = {12, 11, 13, 5, 6, 7};
//         int n = arr.length;

//         mergeSort(arr, 0, n - 1);

//         System.out.println("Mảng sau khi sắp xếp:");
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }

