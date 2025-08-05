package com.example.DesignPatterns;

import java.util.HashMap;
import java.util.Random;
// Flyweight: Đối tượng đạn dùng chung
class BulletFlyweight {
    private final String type; // Loại đạn: "Pistol", "Rifle", "Rocket"
    private final String model3D; // Mô hình 3D
    private final String texture; // Texture

    public BulletFlyweight(String type) {
        this.type = type;
        this.model3D = "Model_" + type;  // Giả sử mỗi loại đạn có một model riêng
        this.texture = "Texture_" + type; // Giả sử mỗi loại đạn có một texture riêng
    }

    public void renderBullet(int x, int y, int z, double direction) {
        System.out.println("Rendering " + type + " bullet at (" + x + ", " + y + ", " + z + ") with direction " + direction);
    }
}

// Factory quản lý Flyweight 
class BulletFactory {
    private static final HashMap<String, BulletFlyweight> bulletMap = new HashMap<>();

    public static BulletFlyweight getBullet(String type) {
        BulletFlyweight bullet = bulletMap.get(type);

        if (bullet == null) {
            bullet = new BulletFlyweight(type);
            bulletMap.put(type, bullet);
            System.out.println("Creating new BulletFlyweight for type: " + type);
        }
        return bullet;
    }
}

// Đối tượng Bullet (Context), chứa dữ liệu riêng
class Bullet {
    private final int x, y, z;
    private final double direction;
    private final BulletFlyweight bulletFlyweight;

    public Bullet(int x, int y, int z, double direction, String type) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.direction = direction;
        this.bulletFlyweight = BulletFactory.getBullet(type);
    }

    public void render() {
        bulletFlyweight.renderBullet(x, y, z, direction);
    }
}
public class Flyweight {

    private static final String[] bulletTypes = {"Pistol", "Rifle", "Rocket"};

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 10; i++) { // Giả sử có 10 viên đạn được bắn
            String type = bulletTypes[random.nextInt(bulletTypes.length)];
            Bullet bullet = new Bullet(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextDouble() * 360, type);
            bullet.render();
        }
    }

}
