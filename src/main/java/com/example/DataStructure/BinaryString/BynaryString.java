package com.example.DataStructure.BinaryString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BynaryString {
    // tìm khoảng cách lớn nhất giữa hai số 1 trong biểu diễn nhị phân của số nguyên dương N
    // phương án 1: độ phức tạp O(n) thời gian, O(n) không gian
    public static int binaryGapSolution(int N){
        String binaryResult = Integer.toBinaryString(N);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < binaryResult.length(); i++) {
            if(binaryResult.charAt(i) == '1'){
                list.add(i);
            }
        }
        int solutionResult = 0;
        for(int i = 1; i < list.size(); i++){
            // đây là lí do sử dụng ArrayList, vì nó giữ thứ tự chèn
            // và truy cập phần tử theo chỉ số nhanh hơn so với LinkedList
            int distance = list.get(i) - list.get(i-1) - 1;
            if(distance > solutionResult){
                solutionResult = distance;
            }
        }
        return solutionResult;
    }
    // phương án 2: độ phức tạp O(n) thời gian, O(1) không gian
    public static int testSolutionGapBinary(int n){
        String binaryResult = Integer.toBinaryString(n);
        int solutionResult = 0;
        int localOne = -1;
        for(int i = 0; i < binaryResult.length(); i++){
            if(binaryResult.charAt(i) == '1'){
                if(localOne != 1){
                    int gap = i - localOne - 1;
                    solutionResult = Math.max(solutionResult, gap);
                }
                localOne = i;
            }
        }
        return solutionResult;
    }


    // tìm độ dài chuỗi con không chứa ký tự trùng lặp
    public static int lengthOfLongestSubstring(String s) {
        int solutionResult = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>(); // không chấp nhận phần tử trùng lặp, thêm, xóa sửa nhanh
        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            solutionResult = Math.max(solutionResult, right - left + 1);
        }
        return solutionResult;
    }


    // tìm chuỗi con palindrome dài nhất trong chuỗi s
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        int start = 0; int end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(s, i, i); // tam le
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }
    private static int expandAroundCenter(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }


    // tìm độ dài chuỗi con có tối đa k ký tự khác nhau
    public static int longestSubstringKDistinct(String s, int k) {
        // kkieerm tra dau vao, chac chan s khong null và số ký tự phải lớn hơn 0
        if(s.isEmpty() || k == 0) return 0;
        int solutionResult = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while(map.size() > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left++;
            }
            solutionResult = Math.max(solutionResult, right - left + 1);
        }
        return solutionResult;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new java.util.HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            java.util.Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    


    public static void main(String[] args) {
        // int test = 1041;
        // int a = binaryGapSolution(test);
        // System.err.println(a);

        // String k = "bacdefajhertyui";
        // System.err.println(lengthOfLongestSubstring(k));
        String s = "abcadcacacaca";
        int z = longestSubstringKDistinct(s, 3);
        System.err.println(z);
        
    }

    
}
