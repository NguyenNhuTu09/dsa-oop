package com.example.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

// Hãy tưởng tượng bạn có một lớp PhongBan (Phòng Ban) chứa danh sách các NhanVien (Nhân Viên) dưới dạng một ArrayList nội bộ. Bây giờ, bạn muốn cung cấp một cách để các bộ phận khác trong chương trình có thể duyệt qua danh sách nhân viên này mà không cần phải biết rằng PhongBan đang sử dụng ArrayList.

interface Iterator<T> {
    boolean hasNext();
    T next();
}

interface Aggregate<T> {
    Iterator<T> createIterator();
}

class NhanVien {
    private String ten;

    public NhanVien(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }
}

class NhanVienIterator implements Iterator<NhanVien> {
    private List<NhanVien> danhSachNhanVien;
    private int position = 0;

    public NhanVienIterator(List<NhanVien> danhSachNhanVien) {
        this.danhSachNhanVien = danhSachNhanVien;
    }

    @Override
    public boolean hasNext() {
        return position < danhSachNhanVien.size() && danhSachNhanVien.get(position) != null;
    }

    @Override
    public NhanVien next() {
        NhanVien nhanVien = danhSachNhanVien.get(position);
        position++;
        return nhanVien;
    }
}

class PhongBan implements Aggregate<NhanVien> {
    private List<NhanVien> danhSachNhanVien;

    public PhongBan() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    public void themNhanVien(NhanVien nv) {
        this.danhSachNhanVien.add(nv);
    }

    // Phương thức này không cần thiết nếu dùng Iterator
    // public List<NhanVien> getDanhSachNhanVien() {
    //     return danhSachNhanVien;
    // }

    @Override
    public Iterator<NhanVien> createIterator() {
        return new NhanVienIterator(this.danhSachNhanVien);
    }
}




public class InteratorPattern {
    public static void main(String[] args) {
        PhongBan phongKeToan = new PhongBan();
        phongKeToan.themNhanVien(new NhanVien("Nguyễn Văn A"));
        phongKeToan.themNhanVien(new NhanVien("Trần Thị B"));
        phongKeToan.themNhanVien(new NhanVien("Lê Văn C"));

        System.out.println("Danh sách nhân viên phòng Kế toán:");
        Iterator<NhanVien> iterator = phongKeToan.createIterator();
        while (iterator.hasNext()) {
            NhanVien nv = iterator.next();
            System.out.println("- " + nv.getTen());
        }

        // Bây giờ, nếu PhongBan thay đổi cách lưu trữ nhân viên (ví dụ dùng mảng),
        // client code này không cần thay đổi, miễn là PhongBan vẫn cung cấp
        // một NhanVienIterator hợp lệ.

        // Ví dụ khác: In danh sách nhân viên phòng Kinh Doanh (có thể là 1 instance khác của PhongBan)
        PhongBan phongKinhDoanh = new PhongBan();
        phongKinhDoanh.themNhanVien(new NhanVien("Phạm Thị D"));
        phongKinhDoanh.themNhanVien(new NhanVien("Hoàng Văn E"));

        System.out.println("\nDanh sách nhân viên phòng Kinh Doanh:");
        Iterator<NhanVien> iteratorKD = phongKinhDoanh.createIterator();
        while (iteratorKD.hasNext()) {
            NhanVien nv = iteratorKD.next();
            System.out.println("- " + nv.getTen());
        }
    }
}
