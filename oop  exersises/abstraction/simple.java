// Abstract class
abstract class Animal {
    public abstract void sound(); // abstract method (no body)

    public void sleep() { // normal method
        System.out.println("Animal is sleeping");
    }
}

// Child class implements abstract method
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

 class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound(); // abstract method implementation
        d.sleep(); // inherited normal method
    }
}
