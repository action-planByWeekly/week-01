// Abstract parent class
abstract class Employee {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    // abstract method must be implemented in child
    public abstract void work();

    public void showDetails() {
        System.out.println("Name: " + name + ", Salary: " + salary);
    }
}

// Child 1
class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, double salary, String programmingLanguage) {
        super(name, salary); // call parent constructor
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }
}

// Child 2
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, double salary, int teamSize) {
        super(name, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void work() {
        System.out.println(name + " is managing a team of " + teamSize + " people");
    }
}

class Main {
    public static void main(String[] args) {
        Employee dev = new Developer("Miyuru", 50000, "Java");
        Employee mgr = new Manager("Nimal", 80000, 5);

        dev.showDetails();
        dev.work();

        mgr.showDetails();
        mgr.work();
    }
}
