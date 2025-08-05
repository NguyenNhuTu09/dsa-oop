package com.example.DataStructure;

import java.util.Stack;

class StackCustom{
    private int[] stack;
    private int capacity;
    private int top;

    public StackCustom(int size){
        stack = new int[size];
        capacity = size;
        top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == capacity - 1;
    }
    public void addStack(int x){
        if(isFull()){
            System.err.println("Ngan xep hien da day");
            return ;
        }
        stack[++top] = x;
    }
    public int peek(){
        if(!isEmpty()){
            return stack[top];
        }
        return -1;
    }
    public int delete(){
        if(isEmpty()){
            System.err.println("Danh sach dang rong, khong the xoa");
            return -1;
        }
        return stack[top--];
    }
}

class QueneCustom{
    private int[] quene;
    private int size;
    private int capacity;
    private int front;
    private int pear;

    public QueneCustom(int size){
        quene = new int[size];
        capacity = size;
        front = 0; // mặc định phần tử đầu tiên ban đầu của Quene có chỉ số là 0
        pear = -1;
        this.size = 0;
    }
    public Boolean isEmpty(){
        return size == 0;
    }
    public Boolean isFull(){
        return size == capacity;
    }
    public void addQuene(int x){
        if(isFull()){
            System.err.println("Quene da day, khong the them");
            return ;
        }
        pear = (pear+1)%capacity;
        quene[pear] = x;
        size++;
    }
    // lay phan tu dau tien ma khong xoa trong Quene
    public int peek(){
        if(!isEmpty()){
            return quene[front];
        }
        return -1;
    }
    // lay phan tu dau tien va xoa trong Quene
    public int delete(){
        if(isEmpty()){
            System.err.println("Quene hien dang rong, khong the xoa");
            return -1;
        }
        int item = quene[front];
        front = (front + 1)%capacity;
        size--;
        return item;
    }
}
public class StackAndQuene {
    public int lengthOfLastWorld(String s){
        Stack<String> test  = new Stack<>();
        String[] words = s.split(" ");
        for(String k: words){
            test.push(k);
        }
        return test.peek().length();
    }
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                char peek = stack.peek();
                if(peek == '(' && s.charAt(i) == ')' ||
                peek == '{' && s.charAt(i) == '}' ||
                peek == '[' && s.charAt(i) == ']'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        // StackCustom stack = new StackCustom(4);
        // stack.addStack(12);
        // stack.addStack(1223);
        // stack.addStack(12);
        // stack.addStack(99);
        // System.out.println("Phan tu dau tien trong stack: " + stack.peek());
        // System.err.println(stack.delete());
        // System.out.println("Phan tu dau tien trong stack: " + stack.peek());

        QueneCustom quene = new QueneCustom(4);
        quene.addQuene(123);
        quene.addQuene(8);
        quene.addQuene(233);
        quene.addQuene(233);
        quene.addQuene(233);
        System.err.println(quene.peek());
        System.err.println(quene.delete());
        System.err.println(quene.peek());
        
    }
}
