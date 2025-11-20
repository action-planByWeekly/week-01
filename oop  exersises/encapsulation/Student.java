//easy example

public class Student {
    private String name; 
    private int age; 

   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Miyuru");
        student.setAge(25);

        System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
