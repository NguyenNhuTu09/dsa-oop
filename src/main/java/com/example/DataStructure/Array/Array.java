package com.example.DataStructure.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Array {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
		for(int num: nums1)
			list.add(num);
		for(int num: nums2){
			list.add(num);
		}
		Collections.sort(list);
		if(list.size() % 2 == 1){
			return list.get(list.size() / 2);
		}else{
			int z = (list.size() - 1) / 2;
			return (list.get(z) + list.get(z + 1)) / 2.0;
		}
    }
    public static int[] solution(int[] a, int K){
        if (a.length == 0 || K % a.length == 0) return a;
        K = K % a.length;
        for(int i = 1; i <= K; i++){ 
            int temp = a[a.length - 1];
            for(int j = a.length - 1; j > 0; j--){
                a[j] = a[j - 1];
            }
            a[0] = temp;
        }
        return a;
    }

    public int solutionOddCurrent_1(int[]A){
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] == A[j]){
                    A[i] = 0;
                    A[j] = 0;
                }
            }
        }
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                result = A[i];
            }
        }
        return result;
    }
    public static int solutionOddCurrent_2(int[]A){
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int index: A){
            map.put(index, map.getOrDefault(index, 0) + 1);
        }
        for(int key: map.keySet()){
            if(map.get(key) % 2 == 1){
                result = key;
            }
        }
        return result;
    }

    public static void SubarraySumEqualsK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == k) {
                count++;
            }

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        System.out.println("Count of subarrays with sum " + k + ": " + count);
    }

    public static void ProductofArrayExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        System.out.print("Product of array except self: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static int maxSubArraySum(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }
        return maxSoFar;
    }
    
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        // int[] a = {1,2,3,4,5};
        // int K = 2;
        // int[] result = solution(a, K);
        // for(int i : result){
        //     System.out.println(i);
        // }
        int nums1[] = {1, 3};
        int nums2[] = {2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
