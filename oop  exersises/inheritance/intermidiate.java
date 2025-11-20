// Grandparent class
class Vehicle {
    public void start() {
        System.out.println("Vehicle started");
    }
}

// Parent class
class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }
}

// Child class
class ElectricCar extends Car {
    @Override
    public void start() {
        System.out.println("Electric Car started silently");
    }
}

 class Main {
    public static void main(String[] args) {
        ElectricCar tesla = new ElectricCar();
        tesla.start(); // Electric Car started silently

        // Using super class reference
        Car car = new ElectricCar();
        car.start(); // Electric Car started silently (runtime polymorphism)
    }
}
