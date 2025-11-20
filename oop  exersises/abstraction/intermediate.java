abstract class Shape {
    public abstract double area(); // must be implemented

    public void print() {
        System.out.println("Calculating area...");
    }
}

// Child 1
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Child 2
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }
}

 class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(4, 6);

        s1.print();
        System.out.println(s1.area());

        s2.print();
        System.out.println(s2.area());
    }
}
