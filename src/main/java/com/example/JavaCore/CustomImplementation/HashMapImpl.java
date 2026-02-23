package com.example.JavaCore.CustomImplementation;

import java.util.LinkedList;
public class HashMapImpl<K, V> {
    private static class Entry<K, V>{
        K key;
        V value;
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public HashMapImpl(){
        size = 0;
        table = new LinkedList[INITIAL_CAPACITY];
    }
    private int getIndex(K key){
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    @SuppressWarnings("unchecked")
    private void resize(){
        LinkedList<Entry<K, V>>[] oldTable = table;
        table = new LinkedList[oldTable.length * 2];
        size = 0;
        for(LinkedList<Entry<K, V>> bucket : oldTable){
            if(bucket != null){
                for(Entry<K, V> entry : bucket){
                    put(entry.key, entry.value);
                }
            }
        }
    }

    public V put(K key, V value){
        if((float) (size + 1) / table.length > LOAD_FACTOR){
            resize();
        }
        int index = getIndex(key);
        if(table[index] == null){
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if ((key == null && entry.key == null) || (key != null && key.equals(entry.key))) {
                V oldValue = entry.value;
                entry.value = value; 
                return oldValue;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
        return null;
    }

    public boolean containsKey(K key){
        int index = getIndex(key);
        if(table[index] == null){
            return false;
        }
        for(Entry<K, V> entry: table[index]){
            if((key == null && entry.key == null) || (key != null && key.equals(entry.key))){
                return true;
            }
        }
        return false;
    }
    public V remove(K key){ 
        int index = getIndex(key);
        if(table[index] == null){
            return null;
        }
        for(Entry<K, V> entry: table[index]){
            if((key == null && entry.key ==  null) || (key != null && key.equals(entry.key))){
                V oldValue = entry.value;
                table[index].remove(entry);
                size--;
                return oldValue;
            }
        }
        return null;
    }

    public V getOrDefault(K key, V defaultValue){
        int index = getIndex(key);
        if(table[index] == null){
            return defaultValue;
        }
        for(Entry<K, V> entry: table[index]){
            if(key == null && entry.key == null || key != null && key.equals(entry.key)){
                return entry.value;
            }
        }
        return defaultValue;
    }

    
    
}
