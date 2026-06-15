/*
Bad Example (OCP Violation)

class AreaCalculator {

    double calculateArea(String shape) {

        if(shape.equals("Circle")) {
            return 3.1416 * 5 * 5;
        }

        else if(shape.equals("Rectangle")) {
            return 10 * 5;
        }

        return 0;
    }
}

Problem
Now circle and rectangle. 
Later, we may need to Triangle.

else if(shape.equals("Triangle")) {
    return 0.5 * 10 * 5;
}

here, we need to modify old tested code which violated OCP.
*/

// Followed by OCP
// Create interface
interface Shape {
    double area();
}

// circle
class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return 3.1416 * radius * radius;
    }
}

// rectangle
class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

// triangle, new one, no need to change in the oldest code.
class Triangle implements Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}

// calculator class
class AreaCalculator {
    double calculateArea(Shape shape) {
        return shape.area();
    }
}

// main class
public class OCP {
    public static void main(String[] args) {

        Shape circle = new Circle(5);

        Shape rectangle = new Rectangle(7, 5);

        Shape triangle = new Triangle(8, 12);

        AreaCalculator calculator = new AreaCalculator();

        System.out.println(calculator.calculateArea(circle));
        System.out.println(calculator.calculateArea(rectangle));
        System.out.println(calculator.calculateArea(triangle));
    }
}
