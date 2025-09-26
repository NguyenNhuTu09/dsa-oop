package com.example.DataStructure.Matrix;

public class Medium {
    // tìm giá trị lớn nhất trong mỗi hàng của ma trận
    public static int[] maxInRows(int[][] matrix) { // aps dung cho ma tran vuong
        int[] result = new int[matrix.length]; // method length of rows
        for(int i = 0; i < matrix.length; i++){
            int max = 0;
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] > max){
                    max = matrix[i][j];
                }
            }
            result[i] = max;
        }
        return result;
    }
    // tìm giá trị lớn nhất trong mỗi cột của ma trận
    public static int[] maxInCols(int[][] maxtrix){
        int rows = maxtrix.length;
        int cols = maxtrix[0].length;
        int[] result = new int[cols];
        for(int i = 0; i < cols; i++){
            int max = Integer.MIN_VALUE;
            for(int j = 0; j < rows; j++){
                if(maxtrix[j][i] > max){
                    max = maxtrix[j][i];
                }
            }
            result[i] = max;
        }
        return result;
    }
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        // int[] result = maxInRows(matrix);
        // for(int i : result){
        //     System.out.println(i);
        // }
        
        int[][] matrix2 = {
            {3,0,9},
            {1,1,7},
            {2,8,18}
        };
        int[] result2 = maxInCols(matrix2);
        for(int i : result2){
            System.out.println(i);
        }

    }
}
