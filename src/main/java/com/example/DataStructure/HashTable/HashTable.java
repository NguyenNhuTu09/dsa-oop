package com.example.DataStructure.HashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class HashTableCustom {
    public int BUCKET;
    public ArrayList<List<Integer>> table;

    public HashTableCustom(int size) {
        BUCKET = size;
        table = new ArrayList<>(BUCKET);
        // Khởi tạo các bucket trống
        for (int i = 0; i < BUCKET; i++) {
            table.add(new LinkedList<>()); 
        }
    }

    public int hashFunction(int key) {
        return key % BUCKET;
    }

    public void insertItem(int key) {
        int index = hashFunction(key);
        List<Integer> chain = table.get(index); 
        if (!chain.contains(key)) { 
            chain.add(key);
        }
    }

    public void displayHashTable() {
        for (int i = 0; i < BUCKET; i++) {
            System.out.print(i + ": ");
            for (Integer key : table.get(i)) {
                System.out.print(key + "->");
            }
            System.out.println();
        }
    }
    public boolean searchItem(int key) {
        int index = hashFunction(key);          // Tìm bucket index
        List<Integer> chain = table.get(index); // Lấy bucket
        return chain.contains(key);             // Kiểm tra key có trong bucket không
    }   
}

public class HashTable {
    public static void main(String[] args) {
        HashTableCustom hashTable = new HashTableCustom(7); // Tạo bảng băm với kích thước 7
        hashTable.insertItem(7);
        hashTable.insertItem(14);
        hashTable.insertItem(2134);
        hashTable.insertItem(284);
        hashTable.insertItem(28);
        hashTable.insertItem(284);
        hashTable.insertItem(571);
        hashTable.displayHashTable(); // In các bucket và các phần tử trong bảng băm
        System.out.println("Search 2134: " + hashTable.searchItem(2134));
    }
}
