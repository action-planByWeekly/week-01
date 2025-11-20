class Shape {
    void draw() {
        System.out.println("Drawing shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing circle");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing rectangle");
    }
}

class Canvas {
    public void render(Shape shape) {
        shape.draw(); // polymorphism happening here
    }
}

 class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        canvas.render(new Circle());
        canvas.render(new Rectangle());
    }
}
