// package com.example.DesignPatterns;
// // Giả sử bạn có một lớp House, đối tượng của lớp này có nhiều thành phần như wall, roof, floor, và door.
// // Để xây dựng một ngôi nhà có các phần tùy chọn khác nhau, bạn có thể sử dụng Builder Pattern:
// // Product
// class House {
//     private String wall;
//     private String roof;
//     private String floor;
//     private String door;
//     public String getWall() {
//         return wall;
//     }
//     public void setWall(String wall) {
//         this.wall = wall;
//     }
//     public String getRoof() {
//         return roof;
//     }
//     public void setRoof(String roof) {
//         this.roof = roof;
//     }
//     public String getFloor() {
//         return floor;
//     }
//     public void setFloor(String floor) {
//         this.floor = floor;
//     }
//     public String getDoor() {
//         return door;
//     }
//     public void setDoor(String door) {
//         this.door = door;
//     }

//     // Getters và Setters cho các thuộc tính...
// }

// // Builder
// interface HouseBuilder {
//     void buildWall();
//     void buildRoof();
//     void buildFloor();
//     void buildDoor();
//     House getHouse();
// }

// // ConcreteBuilder
// class ConcreteHouseBuilder implements HouseBuilder {
//     private House house;
//     public ConcreteHouseBuilder() {
//         house = new House();
//     }

//     @Override
//     public void buildWall() { house.setWall("Concrete Wall"); }
//     @Override
//     public void buildRoof() { house.setRoof("Concrete Roof"); }
//     @Override
//     public void buildFloor() { house.setFloor("Tile Floor"); }
//     @Override
//     public void buildDoor() { house.setDoor("Wooden Door"); }
//     @Override
//     public House getHouse() { return house; }
// }

// class Director {
//     private HouseBuilder builder;

//     public Director(HouseBuilder builder) {
//         this.builder = builder;
//     }

//     public House constructHouse() {
//         builder.buildWall();
//         builder.buildRoof();
//         builder.buildFloor();
//         builder.buildDoor();
//         return builder.getHouse();
//     }
// }


// public class BuilderPatterns {
//     public static void main(String[] args) {
//         // Khởi tạo một builder cụ thể
//         HouseBuilder builder = new ConcreteHouseBuilder();
        
//         // Tạo một Director để điều khiển quá trình xây dựng
//         Director director = new Director(builder);
        
//         // Dùng Director để xây dựng đối tượng House
//         House house = director.constructHouse();
        
//         // Kiểm tra các thuộc tính của House
//         System.out.println("House built with:");
//         System.out.println("Wall: " + house.getWall());
//         System.out.println("Roof: " + house.getRoof());
//         System.out.println("Floor: " + house.getFloor());
//         System.out.println("Door: " + house.getDoor());
//     }
// }
