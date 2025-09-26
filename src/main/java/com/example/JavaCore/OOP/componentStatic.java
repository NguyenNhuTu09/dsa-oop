package com.example.JavaCore.OOP;

class testStaticComponent{ 
    public String name;
    public int age;
    public static String componentName = "testStaticComponent";
    public static int count = 0;
    public testStaticComponent() {
        count++;
    }
    public testStaticComponent(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void setComponentName(String componentName) {
        testStaticComponent.componentName = componentName;
    }
    public static void testMethodStatic(){ // phương thức static chỉ có thể truy cập các biến static
        System.out.println("This is a static method" + componentName);
    }
    public static class staticNestedClass{ // lớp static nested class chỉ có thể truy cập các biến static
        public static int testValue = 10;
        public staticNestedClass() {
            testValue++;
        }
        public void display(){
            System.out.println("This is a static nested class");
            System.out.println("Static component name: " + testStaticComponent.componentName + ", count: " + testValue); 
        }
    }
}
public class componentStatic { 
    public static void main(String[] args) {
        testStaticComponent t1 = new testStaticComponent();
        System.err.println(t1.componentName); // có thể viết như vậy, nhưng không phải best practices
        // bởi theo lý thuyết, thì các biến static thuộc về class, không thuộc về instance
        System.err.println(testStaticComponent.componentName); // cách viết đúng
        System.err.println(testStaticComponent.count);

        testStaticComponent t2 = new testStaticComponent();
        t2.setComponentName("NewComponentName");
        System.err.println(t1.componentName); // biến static thuộc về lớp, cho nên dù bạn có khởi tạo bao nhiêu instance
        // từ đối tượng, thì vẫn chỉ có duy nhất 1 biến tatic dùng chugn giữa các instance đó
        System.err.println(testStaticComponent.componentName);
        System.err.println(testStaticComponent.count);


        testStaticComponent.staticNestedClass nestedObj = new testStaticComponent.staticNestedClass();
        nestedObj.display();
        testStaticComponent.staticNestedClass nestedObj2 = new testStaticComponent.staticNestedClass();
        nestedObj2.display();

        testStaticComponent.testMethodStatic();
    }
}
    