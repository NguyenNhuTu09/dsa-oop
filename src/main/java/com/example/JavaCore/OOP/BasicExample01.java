package com.example.JavaCore.OOP;

abstract class Classic {
	public String nameClass;
	Classic(){
		System.out.println("This is Classic");
	}
}

class Student extends Classic{
	public String nameStudent;
	public int age;
	Student(){
		System.out.println("This is Student");
	}
}
public class BasicExample01 {
    public static void main(String[] args) {
        Student student = new Student();
        // student.nameClass = "Lớp 10A1";
        // student.nameStudent = "Nguyễn Văn A";
        // student.age = 15;
        // System.out.println("Tên lớp: " + student.nameClass);
        // System.out.println("Tên học sinh: " + student.nameStudent);
        // System.out.println("Tuổi: " + student.age);
    }
}
