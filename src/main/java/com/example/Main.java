package com.example;
import com.example.JavaCore.CustomImplementation.HashMapImpl;
import com.example.JavaCore.CustomImplementation.LinkedListImpl;

public class Main {
    public static void main(String[] args) {
        HashMapImpl<String, Integer> map = new HashMapImpl<>();
        map.put("One", 1);
        map.put("Two", 2);    
        map.put("Three", 3);
        map.getOrDefault("Four", 4);
        System.out.println(map.getOrDefault("One", 2)); 

        LinkedListImpl<Integer> list = new LinkedListImpl<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 4);
        System.out.println(list.get(1));
        System.out.println(list.remove(2));

    }
}
