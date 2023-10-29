abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Triangle extends Shape {
    private final double base;
    private final double height;
    private final double side1, side2, side3;
    static final String COLOR = "Red";
    static final String SHAPE = "Triangle";

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }
}

class Rectangle extends Shape {
    private final double length;
    private final double breadth;
    static final String COLOR = "Blue";
    static final String SHAPE = "Rectangle";

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double calculateArea() {
        return length * breadth;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + breadth);
    }
}

class Circle extends Shape {
    private final double radius;
    static final String COLOR = "Yellow";
    static final String SHAPE = "Circle";
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Square extends Rectangle {
    static final String COLOR = "Green";
    static final String SHAPE = "Square";

    public Square(double side) {
        super(side, side);
    }
}

public class Main {
    public static void main(String[] args) {
        // Polymorphism
        Shape triangle = new Triangle(5, 10, 5, 6, 7);
        Shape rectangle = new Rectangle(10, 20);
        Shape circle = new Circle(10);
        Shape square = new Square(10);

        System.out.println("The area of the triangle " + triangle.calculateArea());
        System.out.println("The area of the triangle " + triangle.calculatePerimeter());
        System.out.println("The color of triangle " + Triangle.COLOR);
        System.out.println("The area of the rectangle " + rectangle.calculateArea());
        System.out.println("The area of the triangle " + rectangle.calculatePerimeter());
        System.out.println("The Color of rectangle is " + Rectangle.COLOR);
        System.out.println("The area of the circle: " + circle.calculateArea());
        System.out.println("The area of the triangle " + circle.calculatePerimeter());
        System.out.println("The Color of rectangle is " + Circle.COLOR);
        System.out.println("THe area of the Square: " + square.calculateArea());
        System.out.println("The area of the triangle " + square.calculatePerimeter());
        System.out.println("The Color of rectangle is " + Square.COLOR);
    }
}
