package com.example.DataStructure.BinaryString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class BynaryString {
    public static int binaryGapSolution(int N){
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

    public static int longestSubstringKDistinct(String s, int k) {
        if (k == 0 || s.isEmpty()) return 0;
        java.util.Map<Character, Integer> map = new java.util.HashMap<>();
        int left = 0, maxLen = 0;
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            while (map.size() > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                if (map.get(s.charAt(left)) == 0) map.remove(s.charAt(left));
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
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
        int test = 1041;
        int a = binaryGapSolution(test);
        System.err.println(a);

        String s = "babad";
        String result = longestPalindrome(s);
        System.err.println(result);



        
    }

    
}
