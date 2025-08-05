package com.example.DesignPatterns;

// Một hệ thống cần xử lý các biểu thức toán học đơn giản (cộng, trừ, nhân, chia) được biểu diễn dưới dạng chuỗi. Ví dụ: "5 + 3", "10 - 2", "4 * 6", "8 / 2". Hệ thống sẽ sử dụng Interpreter Pattern để phân tích và tính toán kết quả của các biểu thức này.

// Abstract Expression
interface Expression {
    int interpret();
}

// Terminal Expression: Number
class Number implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int interpret() {
        return value;
    }
}

// Abstract Non-Terminal Expression: Operator
abstract class Operator implements Expression {
    protected Expression leftOperand;
    protected Expression rightOperand;

    public Operator(Expression leftOperand, Expression rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }
}

// Concrete Non-Terminal Expression: Addition
class Addition extends Operator {
    public Addition(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() + rightOperand.interpret();
    }
}

// Concrete Non-Terminal Expression: Subtraction
class Subtraction extends Operator {
    public Subtraction(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() - rightOperand.interpret();
    }
}

// Concrete Non-Terminal Expression: Multiplication
class Multiplication extends Operator {
    public Multiplication(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() * rightOperand.interpret();
    }
}

// Concrete Non-Terminal Expression: Division
class Division extends Operator {
    public Division(Expression leftOperand, Expression rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public int interpret() {
        return leftOperand.interpret() / rightOperand.interpret();
    }
}


public class Interpreter {
    public static void main(String[] args) {
        // Example expressions
        String[] expressions = {"5 + 3", "10 - 2", "4 * 6", "8 / 2"};

        for (String expression : expressions) {
            System.out.println("Expression: " + expression);
            Expression parsedExpression = parseExpression(expression);
            int result = parsedExpression.interpret();
            System.out.println("Result: " + result + "\n");
        }
    }

    // Parse the input string into an Expression tree
    private static Expression parseExpression(String expression) {
        String[] tokens = expression.split(" ");
        Expression leftOperand = new Number(Integer.parseInt(tokens[0]));
        String operator = tokens[1];
        Expression rightOperand = new Number(Integer.parseInt(tokens[2]));

        return switch (operator) {
            case "+" -> new Addition(leftOperand, rightOperand);
            case "-" -> new Subtraction(leftOperand, rightOperand);
            case "*" -> new Multiplication(leftOperand, rightOperand);
            case "/" -> new Division(leftOperand, rightOperand);
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        };
    }
}
