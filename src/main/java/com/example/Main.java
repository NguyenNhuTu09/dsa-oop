package com.example;


import com.example.JavaCore.CustomImplementation.HashMapImpl;

public class Main {
    public static void main(String[] args) {
        HashMapImpl<String, Integer> map = new HashMapImpl<>();
        map.put("One", 1);
        map.put("Two", 2);    
        map.put("Three", 3);
        map.getOrDefault("Four", 4);
        System.out.println(map.getOrDefault("One", 2)); 
    }
}
