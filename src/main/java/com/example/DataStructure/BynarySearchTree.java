package com.example.DataStructure;
// do phuc tap O(logn0=)
class Node {
    int data;
    Node left;
    Node right; // khác biệt so với LinkedList thông thường, là Node này sẽ không tham chiêus đến node kia

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree { // khá giống với LinkedList, nó cũng chỉ khởi tạo một lần, và chỉ định phần tử root là phần tử cha đầu tiên
    private Node root;

    public BinarySearchTree() { // constructor
        root = null;
    }

    // phương thức chèn 1 phần tử vào cây
    public void insert(int data) { 
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) { // trả về một Node của BinarySearchTree, mỗi Node này sẽ có data, và 2 Node là left và Right
        // lưu ý Node root ở đây chỉ nằm trong phạm vi của hàm này
 
        if (root == null) { 
            root = new Node(data);
            return root;
        }

        if (data < root.data) { // nếu data truyền vào bé hơn data giá trị của Node root truyền vào, trỏ đến Node left , tiếp tục đệ quy hàm
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // kiểm tra phần tử có nằm trong BynarySearchTree không
    public boolean search(int data) {
        return searchRec(root, data);
    }

    // đệ quy để tìm phần tử 
    private boolean searchRec(Node root, int data) {
        // trường hợp cây rỗng hoặc không tìm thấy phần tử
        if (root == null) {
            return false;
        }

        // khi tìm thấy phần tử
        if (root.data == data) {
            return true;
        }

        if (data < root.data) { // nếu dữ liệu hiện tại bé hơn node đi cùng, dịch sang trái, đệ quy tiếp tục
            return searchRec(root.left, data);
        } else { // nếu dữ liệu hiện tại lớn hơn node đi cùng, dịch sang phải, đệ quy tiếp tục
            return searchRec(root.right, data);
        }
    }

     // Phương thức hiển thị cây theo thứ tự giữa (in-order traversal)
    public void inOrderTraversal() {
        inOrderRec(root);
        System.out.println();
    }
    // Hàm đệ quy để hiển thị cây theo thứ tự giữa
    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }
}

public class BynarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Hiển thị cây theo thứ tự giữa
        System.out.print("In-order Traversal: ");
        bst.inOrderTraversal();  // Kết quả: 20 30 40 50 60 70 80

        // Tìm kiếm các phần tử
        int key = 40;
        if (bst.search(key)) {
            System.out.println("Phần tử " + key + " tồn tại trong cây.");
        } else {
            System.out.println("Phần tử " + key + " không tồn tại trong cây.");
        }
    }
}
