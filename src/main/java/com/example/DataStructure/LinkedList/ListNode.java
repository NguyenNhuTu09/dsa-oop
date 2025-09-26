package com.example.DataStructure.LinkedList;

import java.util.HashSet;

class Node{
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    } // 1 -> 3 -> 5 -> 7 -> null
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
    public static Node addTwoNumbers(Node a, Node b){
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
    public static Node mergeTwoList(Node a, Node b){
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
        tail.next = b == null ? a : b;
        return dummy.next;
    }

    public static Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        while(current != null){
            Node nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static void deleteByValue(Node head, int value){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(head != null){
            if(head.data != value){
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        head = dummy.next;
    }


    public static Node detectCycle(Node head) {
        Node result = null;
        HashSet<Node> set = new HashSet<>();
        while(head != null){
        	if(set.contains(head)){
                result = head;
                return result;
            }
        	else{
        		set.add(head);
            }
        	head = head.next;
        }
        return null;
    }

    public static Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy, slow = dummy;
        for (int i = 0; i <= k; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        // Find middle
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse second half
        Node prev = null, curr = slow;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        // Compare two halves
        Node first = head, second = prev;
        while (second != null) {
            if (first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(3);
        Node c = new Node(13);

        Node d = new Node(4); 
        Node g = new Node(5);
        Node f = new Node(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = g;
        g.next = f;
        // Node k = addTwoNumbers(a, d);
        // while(k != null){
        //     System.out.print(k.data + " -> ");
        //     k = k.next;
        // }

        // Node z = mergeTwoList(a, d);
        // while(z != null){
        //     System.out.print(z.data + " -> ");
        //     z = z.next;
        // }
        // Node z = reverseList(a);
        // while(z != null){
        //     System.out.print(z.data + " -> ");
        // }

        // Node z = detectCycle(a);
        // if(z != null){
        //     System.out.println("Cycle detected at node with value: " + z.data);
        // } else {
        //     System.out.println("No cycle detected.");
        // }
        Node z = findMiddle(a);
        System.out.println("Middle node value: " + z.data);
        
    }
}
