package com.example.DataStructure;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    Node head;
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next!= null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
    }
}

public class ListNode {
    public Node addTwoNumbers(Node a, Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        while(a != null || b != null){
            int sum = a.data + b.data + carry; 
            if(sum >= 10){
                carry = 1;
            }else{
                carry = 0;
            }
            tail.next = new Node((sum % 10));
            a = a.next;
            b = b.next;
            tail = tail.next;
        }
        return dummy.next;
    }
    public Node mergeTwoList(Node a, Node b){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(a != null & b != null){
            if(a.data < b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = a == null ? b : a;
        return dummy.next;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);

        Node d = new Node(4); 
        Node g = new Node(5);
        Node f = new Node(6);
        a.next = b;
        b.next = c;

        d.next = g;
        g.next = f;


        ListNode listNode = new ListNode();
        Node result = listNode.addTwoNumbers(a, d);
        while(result != null){
            System.err.println(result.data);
            result = result.next;
        }
        
        
    }
}
