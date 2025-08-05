package com.example;


public class Main {
    
    public static int removeDuplicates(int[] nums){
        // đề bài yêu cầu in-place, là sửa trực tiếp trên mảng đề bài đã cho
        // không được tạo mảng riêng biệt
        if(nums.length == 0) return 0;
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
                
        }
        return i + 1;
    }
    
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.err.println(removeDuplicates(arr));
    }
}
