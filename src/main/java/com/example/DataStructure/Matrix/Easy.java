package com.example.DataStructure.Matrix;

public class Easy {
    // tính tổng đường chéo chính ma trậntrận
    public static int sumDiagonalSolution(int[][] matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][i];
        }
        return sum;
    }
    // tính tổng đường chéo phụ ma trận
    public static int sumAntiDiagonalSolution(int[][] matrix){
        int sum = 0;
        for(int i = 0; i < matrix.length; i++){
            sum += matrix[i][matrix.length -1-i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [][] matrix = {
            {1, 2, 3}, // a[0][2]
            {4, 5, 6}, // a[1][1]
            {7, 8, 9} // a[2][0]
        };
        System.err.println(sumDiagonalSolution(matrix));
        System.err.println(sumAntiDiagonalSolution(matrix));
    }
}
