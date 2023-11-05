import java.io.*;

abstract class Shape implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

class Triangle extends Shape implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
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
    @Serial
    private static final long serialVersionUID = 1L;
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
    @Serial
    private static final long serialVersionUID = 1L;
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
    @Serial
    private static final long serialVersionUID = 1L;
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

        serializeShape(triangle, "triangle.ser");
        serializeShape(rectangle, "rectangle.ser");
        serializeShape(circle, "circle.ser");
        serializeShape(square, "square.ser");
        Shape deserializedTriangle =  deserializeShape("triangle.ser");
        Shape deserializedRectangle =  deserializeShape("rectangle.ser");
        Shape deserializedCircle =  deserializeShape("circle.ser");
        Shape deserializedSquare =  deserializeShape("square.ser");

        assert deserializedTriangle != null;
        System.out.println("Deserialized Triangle Area: " + deserializedTriangle.calculateArea());
        System.out.println("Deserialized Triangle Perimeter: " + deserializedTriangle.calculatePerimeter());
        assert deserializedRectangle != null;
        System.out.println("Deserialized Rectangle Area: " + deserializedRectangle.calculateArea());
        System.out.println("Deserialized Rectangle Perimeter: " + deserializedRectangle.calculatePerimeter());
        assert deserializedCircle != null;
        System.out.println("Deserialized Circle Area: " + deserializedCircle.calculateArea());
        System.out.println("Deserialized Circle Perimeter: " + deserializedCircle.calculatePerimeter());
        assert deserializedSquare != null;
        System.out.println("Deserialized Square Area: " + deserializedSquare.calculateArea());
        System.out.println("Deserialized Square Perimeter: " + deserializedSquare.calculatePerimeter());
    }
    private static void serializeShape(Shape shape, String filename) {

        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(shape);
            System.out.println("Serialized " + shape.getClass().getSimpleName() + " to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Shape deserializeShape(String filename) {
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            return (Shape) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
