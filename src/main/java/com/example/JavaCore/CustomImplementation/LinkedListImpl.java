package com.example.JavaCore.CustomImplementation;

public class LinkedListImpl<E> {
    private class Node {
        E data;
        Node next, prev;
        Node(E data) { this.data = data; }
    }

    private Node head, tail;
    private int size;

    public void add(E element) {
        Node newNode = new Node(element);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(element);
        if (index == size) {
            add(element);
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) current = current.next;
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        E data = current.data;
        if (size == 1) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return data;
    }

    public int size() { return size; } 
}