package com.example.JavaCore.OOP;

abstract class HinhHoc{
    String color;
    abstract void tinhDienTich();
    abstract void tinhChuVi();

    public HinhHoc() {
        System.err.println("HinhHoc Constructor");
    }

    public HinhHoc(String color) {
        this.color = color;
    }

    void test(){
        System.out.println("Test method in abstract class");
    }
    
    // có thể có các phương thức không trừu tượng
    // có thể có các thuộc tính
    
}
class HinhChuNhat extends HinhHoc{
    int chieuDai;
    int chieuRong;

    public HinhChuNhat() {
        System.out.println("HinhChuNhat Constructor");
    }
    
    
    HinhChuNhat(int chieuDai, int chieuRong, String color){
        // super();
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
        this.color = color;
    }
    @Override
    void tinhDienTich() {
        System.out.println("Dien tich hinh chu nhat: " + (chieuDai * chieuRong));
    }

    @Override
    void tinhChuVi() {
        System.out.println("Chu vi hinh chu nhat: " + 2 * (chieuDai + chieuRong));
    }

    @Override
    void test() {
        // super.test();
        System.out.println("Test method in HinhChuNhat class");
    }
    
}

interface car{
    void start();
    void stop();
    void honk();
    // interface không có thuộc tính, chỉ có hằng số (static final)
    // tất cả các phương thức trong interface mặc định là public abstract
    // không thể có phương thức cụ thể (có thân) trừ khi là phương thức mặc định (default) hoặc tĩnh (static)
}
class BMW implements car{
    String name;
    @Override
    public void honk() {
        System.out.println("BMW honk: Beep Beep!");
    }

    @Override
    public void start() {
        System.out.println("BMW started");
    }

    @Override
    public void stop() {
        System.out.println("BMW stopped");
    }
    
}
class Audi implements car{
    String name;
    @Override
    public void honk() {
        System.out.println("Audi honk: Honk Honk!");
    }

    @Override
    public void start() {
        System.out.println("Audi started");
    }

    @Override
    public void stop() {
        System.out.println("Audi stopped");
    }
    
}
// một class có thể kế thừa một class khác (kế thừa đơn) và có thể triển khai nhiều interface
// khi thừa kế lại abstract class và implement lại interface, phải định nghĩa lại tất cả các phương thức trừu tượng
public class itfAndAbs {
    public static void main(String[] args) {
        HinhHoc hcn = new HinhChuNhat(5, 10, "Red");
        hcn.tinhDienTich();
        hcn.tinhChuVi();
        hcn.test();

        // car bmw = new BMW();
        // bmw.start();    
        // bmw.honk();
        // bmw.stop();
        
        // car audi = new Audi();
        // audi.start();
        // audi.honk();
        // audi.stop();
    }
}
