interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Duck flies");
    }

    @Override
    public void swim() {
        System.out.println("Duck swims");
    }
}

class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane flies");
    }
}

 class Main {
    public static void main(String[] args) {
        Flyable f1 = new Duck();
        Swimmable s1 = new Duck();
        Flyable f2 = new Airplane();

        f1.fly();
        s1.swim();
        f2.fly();
    }
}
