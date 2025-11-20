//advanced example


import java.util.ArrayList;
import java.util.List;

public final class Employee {   
    private final String name;
    private final List<String> skills;    

    public Employee(String name, List<String> skills) {
        this.name = name;

        // defensive copy → TRUE encapsulation
        this.skills = new ArrayList<>(skills);
    }

    public String getName() {
        return name;
    }

    // return COPY, not original list
    public List<String> getSkills() {
        return new ArrayList<>(skills);
    }
}

class Main {
    public static void main(String[] args) {
        List<String> skillList = new ArrayList<>();
        skillList.add("Java");
        skillList.add("Spring Boot");

        Employee emp = new Employee("Miyuru", skillList);

        // try to modify original list
        skillList.add("React");  
        
        emp.getSkills().add("Hacking");

        System.out.println(emp.getSkills());  
       
    }
}
