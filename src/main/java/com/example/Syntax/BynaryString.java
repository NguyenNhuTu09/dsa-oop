package com.example.Syntax;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class BynaryString {
    public static int solution(int N){
        String binaryResult = Integer.toBinaryString(N);
        char[] test = binaryResult.toCharArray();
        int solutionResult = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < test.length; i++){
            if(test[i] == '1'){
                list.add(i);
            }
        }
        System.err.println("list " + list);
        for(int i = 1; i < list.size(); i++){
            int test_1 = list.get(i) - list.get(i-1) - 1;
            if(test_1 > solutionResult){
                solutionResult = test_1;
            }
        }
        return solutionResult;
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    


    public static void main(String[] args) {
        int test = 1041;
        int a = solution(test);
        System.err.println(a);

        LinkedList<Integer> test01 = new LinkedList<>();
        test01.add(12);
        test01.add(122);
        test01.add(9);
        test01.add(8);
        test01.add(1);
        Collections.sort(test01);
        System.err.println(test01);
    }

    
}
