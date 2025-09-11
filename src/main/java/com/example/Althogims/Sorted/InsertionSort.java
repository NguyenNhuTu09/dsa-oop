package com.example.Althogims.Sorted;

// Thuật toán Insertion Sort là một thuật toán sắp xếp đơn giản nhưng hiệu quả 
// cho các danh sách nhỏ hoặc khi dữ liệu gần như đã được sắp xếp. Thuật toán này hoạt động bằng cách 
// duyệt từng phần tử trong danh sách và chèn nó vào vị trí đúng trong dãy đã được sắp xếp phía trước nó.

// 1. Cách hoạt động của Insertion Sort
// Bắt đầu từ phần tử thứ hai, lấy phần tử đó và so sánh với các phần tử trước nó.
// Dịch các phần tử lớn hơn (nếu có) lên một vị trí để tạo chỗ trống cho phần tử cần chèn.
// Chèn phần tử vào vị trí thích hợp.
// Lặp lại cho tất cả các phần tử trong danh sách.
// Ví dụ: Giả sử bạn có một mảng: [5, 2, 9, 1, 5, 6]

// Sau lần đầu tiên, phần tử 2 sẽ được đặt vào vị trí trước 5: [2, 5, 9, 1, 5, 6]
// Sau đó, phần tử 9 được giữ nguyên vì nó đã ở vị trí đúng.
// Tiếp theo, phần tử 1 sẽ được chèn vào trước 2: [1, 2, 5, 9, 5, 6]
// Quá trình lặp lại cho đến khi toàn bộ mảng được sắp xếp.
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length; // lấy độ dài mảng
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // lấy phần tử thứ 2 cuả mảng 
            int j = i - 1; // lấy phần tử trước phần tử key

            // Dịch các phần tử lớn hơn key về bên phải
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    } 
    public static void main(String[] args) {
        
    }
}
