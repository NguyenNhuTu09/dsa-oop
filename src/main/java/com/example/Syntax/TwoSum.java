package com.example.Syntax;

import java.util.HashMap;


public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++){
            int k = target - nums[i];
            if(map.containsKey(k)){
                return new int[] {
                    map.get(k), i
                };
            }
            map.put(nums[i], i);
        }
        return nums;
    }
    public static void main(String[] args) {
        int[] a = new int[] {2, 7, 11, 15};
        int[] b = twoSum(a, 9);
        for(int i = 0; i < b.length; i++){
            System.out.print(b[i] + " ");
        }
    }
}
