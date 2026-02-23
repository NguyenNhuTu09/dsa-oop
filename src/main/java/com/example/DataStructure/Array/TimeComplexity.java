package com.example.DataStructure.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TimeComplexity {
    public static int solutionJump(int X, int Y, int D){
        int countJump = 0;
        do { 
            X += D;
            countJump++;
        } while (X < Y);
        return countJump;
    }
    public static void CreateVersion(){
        System.err.println("This is a placeholder for CreateVersion method.");
    }
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
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
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;
        System.err.println(solutionJump(X, Y, D));
        CreateVersion();
    }
}
