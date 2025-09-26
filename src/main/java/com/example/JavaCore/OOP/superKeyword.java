package com.example.JavaCore.OOP;

class Animal{
    private String name;
    Animal(){
        System.out.println("Animal Constructor: ");
    }
    public Animal(String name) {
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void printNameAnimal(){
        System.out.println("Animal name: " + name);
    }
    
}
class Dog extends Animal{
    int age;
    Dog(){
        // super();
        System.out.println("Dog Constructor");
    }
    void printAge(){
        System.out.println("Dog age: " + age);
    }
}
public class superKeyword {
    public static void main(String[] args) {
        // A a = new A();
        // B b = new B();
        Animal a = new Dog(); 
        a.setName("Dog");
        a.printNameAnimal();
        
    }
}
