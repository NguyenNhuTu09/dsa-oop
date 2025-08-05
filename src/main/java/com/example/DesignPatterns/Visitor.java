package com.example.DesignPatterns;
// Chúng ta có 2 loại phần tử:

// Book

// Fruit

// Chúng đều là các đối tượng thuộc kiểu ItemElement.
// Chúng ta muốn tính giá tiền của từng loại nhưng không muốn đặt logic tính tiền bên trong chính các lớp Book hay Fruit.
// => Vậy nên ta sử dụng Visitor Pattern để tách riêng logic xử lý (giá tiền) ra một lớp ShoppingCartVisitor.

interface ItemElement {
    int accept(ShoppingCartVisitor visitor);
}

class Book implements ItemElement {
    private int price;
    private String isbnNumber;

    public Book(int price, String isbnNumber) {
        this.price = price;
        this.isbnNumber = isbnNumber;
    }

    public int getPrice() {
        return price;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);  // gọi visitor.visit(Book)
    }
}

class Fruit implements ItemElement {
    private int pricePerKg;
    private int weight;
    private String name;

    public Fruit(int pricePerKg, int weight, String name) {
        this.pricePerKg = pricePerKg;
        this.weight = weight;
        this.name = name;
    }

    public int getPricePerKg() {
        return pricePerKg;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public int accept(ShoppingCartVisitor visitor) {
        return visitor.visit(this);  // gọi visitor.visit(Fruit)
    }
}

interface ShoppingCartVisitor {
    int visit(Book book);
    int visit(Fruit fruit);
}

class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

    @Override
    public int visit(Book book) {
        int cost = book.getPrice();
        if (cost > 50) {
            System.out.println("Book ISBN: " + book.getIsbnNumber() + " => $" + cost + " (Free Shipping)");
        } else {
            System.out.println("Book ISBN: " + book.getIsbnNumber() + " => $" + cost + " (+$5 shipping)");
            cost += 5;
        }
        return cost;
    }

    @Override
    public int visit(Fruit fruit) {
        int cost = fruit.getPricePerKg() * fruit.getWeight();
        System.out.println(fruit.getName() + " cost = $" + cost);
        return cost;
    }
}

public class Visitor {
    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
            new Book(60, "1234"),
            new Book(30, "5678"),
            new Fruit(2, 5, "Banana"),
            new Fruit(3, 2, "Apple")
        };

        int total = calculatePrice(items);
        System.out.println("Total Cost = $" + total);
    }

    private static int calculatePrice(ItemElement[] items) {
        ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
        int sum = 0;
        for (ItemElement item : items) {
            sum += item.accept(visitor);
        }
        return sum;
    }
}
