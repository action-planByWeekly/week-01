

import java.util.Scanner; // Import Scanner for reading user input from command line
import java.util.ArrayList; // Import ArrayList to store students dynamically
import java.util.InputMismatchException; // Import to handle non-int inputs safely
import java.util.Optional; // Import Optional for safe search results

// Main public class - file name must match this class name
public class StudentManagementSystem {

    // Entry point of the program
    public static void main(String[] args) {
        // Create a Scanner instance to read input from System.in (keyboard)
        Scanner scanner = new Scanner(System.in);

        // Create an instance of StudentManager which manages CRUD operations
        StudentManager manager = new StudentManager();

        // Show a welcome message to the user
        System.out.println("===== Student Management System =====");

        // Start the main program loop; it will run until user chooses to exit
        boolean running = true;
        while (running) {
            // Print the menu options
            System.out.println("\nMenu:");
            System.out.println("1. Add student");
            System.out.println("2. View all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Update student by ID");
            System.out.println("5. Delete student by ID");
            System.out.println("6. Exit");

            // Ask user to choose an option
            System.out.print("Choose an option (1-6): ");

            try {
                // Read the user's menu choice as integer
                int choice = Integer.parseInt(scanner.nextLine().trim());

                // Handle the choice using a switch statement
                switch (choice) {
                    case 1:
                        // Add a new student
                        addStudentFlow(scanner, manager);
                        break;
                    case 2:
                        // View all students
                        viewAllStudentsFlow(manager);
                        break;
                    case 3:
                        // Find student by ID
                        findStudentFlow(scanner, manager);
                        break;
                    case 4:
                        // Update student details
                        updateStudentFlow(scanner, manager);
                        break;
                    case 5:
                        // Delete student
                        deleteStudentFlow(scanner, manager);
                        break;
                    case 6:
                        // Exit the program
                        System.out.println("Exiting... Goodbye!");
                        running = false;
                        break;
                    default:
                        // Any number outside 1-6 is invalid
                        System.out.println("Invalid option. Please enter a number between 1 and 6.");
                }
            } catch (NumberFormatException e) {
                // Handle case when user enters non-integer input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Close the scanner to free resources
        scanner.close();
    }

    // Helper method to run the "add student" flow
    private static void addStudentFlow(Scanner scanner, StudentManager manager) {
        // Ask for student's name
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine().trim();

        // Ask for student's age (loop until valid int entered)
        int age = readIntWithPrompt(scanner, "Enter student's age: ");

        // Ask for student's email
        System.out.print("Enter student's email: ");
        String email = scanner.nextLine().trim();

        // Create and add the student using manager
        Student s = manager.addStudent(name, age, email);

        // Inform the user the student was added and show the assigned ID
        System.out.println("Student added with ID: " + s.getId());
    }

    // Helper method to show all students
    private static void viewAllStudentsFlow(StudentManager manager) {
        // Get the list of students
        ArrayList<Student> list = manager.getAllStudents();

        // If list is empty, tell the user
        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        // Otherwise, print each student's details
        System.out.println("\n--- All Students ---");
        for (Student s : list) {
            System.out.println(s);
        }
    }

    // Helper method to find student by ID
    private static void findStudentFlow(Scanner scanner, StudentManager manager) {
        int id = readIntWithPrompt(scanner, "Enter student ID to find: ");
        Optional<Student> found = manager.findById(id);
        if (found.isPresent()) {
            System.out.println("Student found:");
            System.out.println(found.get());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Helper method to update student by ID
    private static void updateStudentFlow(Scanner scanner, StudentManager manager) {
        int id = readIntWithPrompt(scanner, "Enter student ID to update: ");
        Optional<Student> found = manager.findById(id);
        if (found.isEmpty()) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        Student s = found.get(); // existing student object

        // Show current details before update
        System.out.println("Current details: " + s);

        // Ask for new name (or blank to keep existing)
        System.out.print("Enter new name (leave blank to keep \"" + s.getName() + "\"): ");
        String newName = scanner.nextLine().trim();
        if (newName.isEmpty()) {
            newName = s.getName();
        }

        // Ask for new age (or blank to keep existing)
        System.out.print("Enter new age (leave blank to keep " + s.getAge() + "): ");
        String ageInput = scanner.nextLine().trim();
        int newAge;
        if (ageInput.isEmpty()) {
            newAge = s.getAge();
        } else {
            try {
                newAge = Integer.parseInt(ageInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid age entered. Keeping existing age: " + s.getAge());
                newAge = s.getAge();
            }
        }

        // Ask for new email (or blank to keep existing)
        System.out.print("Enter new email (leave blank to keep \"" + s.getEmail() + "\"): ");
        String newEmail = scanner.nextLine().trim();
        if (newEmail.isEmpty()) {
            newEmail = s.getEmail();
        }

        // Perform update via manager
        boolean updated = manager.updateStudent(id, newName, newAge, newEmail);
        if (updated) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Failed to update student.");
        }
    }

    // Helper method to delete student by ID
    private static void deleteStudentFlow(Scanner scanner, StudentManager manager) {
        int id = readIntWithPrompt(scanner, "Enter student ID to delete: ");
        boolean deleted = manager.deleteStudent(id);
        if (deleted) {
            System.out.println("Student with ID " + id + " deleted.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    // Utility method to read an integer from user with prompt; repeats until valid
    // integer is entered
    private static int readIntWithPrompt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt); // show the prompt
            String input = scanner.nextLine(); // read a full line
            try {
                return Integer.parseInt(input.trim()); // try to parse int and return
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer."); // if parse fails, inform user
            }
        }
    }
}

// Student class: represents a student (entity/model)
class Student {
    // Private fields (encapsulation) — they cannot be accessed directly outside
    // this class
    private int id; // unique numeric ID for each student
    private String name; // student's full name
    private int age; // student's age
    private String email; // student's email address

    // Constructor to initialize a new Student object with all fields
    public Student(int id, String name, int age, String email) {
        this.id = id; // set id field to constructor parameter id
        this.name = name; // set name field
        this.age = age; // set age field
        this.email = email; // set email field
    }

    // Getter for id
    public int getId() {
        return id; // return the id of the student
    }

    // Setter for id (rarely used here but provided for completeness)
    public void setId(int id) {
        this.id = id; // update the id field with new value
    }

    // Getter for name
    public String getName() {
        return name; // return student's name
    }

    // Setter for name
    public void setName(String name) {
        this.name = name; // update the name field
    }

    // Getter for age
    public int getAge() {
        return age; // return student's age
    }

    // Setter for age
    public void setAge(int age) {
        this.age = age; // update the age field
    }

    // Getter for email
    public String getEmail() {
        return email; // return student's email
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email; // update the email field
    }

    // toString method to display student information nicely when printing
    @Override
    public String toString() {
        // Build and return a readable string representation of the student
        return "ID: " + id + " | Name: " + name + " | Age: " + age + " | Email: " + email;
    }
}

// StudentManager class: handles storage and CRUD operations for Student objects
class StudentManager {
    // List to hold students in memory (no database, simple in-memory storage)
    private ArrayList<Student> students;

    // Next id to assign to a new student (simple auto-increment logic)
    private int nextId;

    // Constructor to initialize fields
    public StudentManager() {
        students = new ArrayList<>(); // create an empty ArrayList to store Student objects
        nextId = 1; // start assigning IDs from 1
    }

    // Method to add a new student; returns the created Student object
    public Student addStudent(String name, int age, String email) {
        Student s = new Student(nextId, name, age, email); // create Student with current nextId
        students.add(s); // add the new student to the list
        nextId++; // increment nextId for future students
        return s; // return the newly created Student
    }

    // Method to get all students (returns a new list to prevent external
    // modification)
    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students); // return a shallow copy of internal list
    }

    // Method to find a student by ID and return Optional<Student>
    public Optional<Student> findById(int id) {
        // Loop through the list and compare each student's id
        for (Student s : students) {
            if (s.getId() == id) {
                return Optional.of(s); // found: return Optional containing the student
            }
        }
        return Optional.empty(); // not found: return empty Optional
    }

    // Method to update a student's details; returns true if successful
    public boolean updateStudent(int id, String newName, int newAge, String newEmail) {
        Optional<Student> result = findById(id); // search for student by id
        if (result.isEmpty()) {
            return false; // student not found; cannot update
        }
        Student s = result.get(); // get the found student
        s.setName(newName); // update name field
        s.setAge(newAge); // update age field
        s.setEmail(newEmail); // update email field
        return true; // update successful
    }

    // Method to delete a student by ID; returns true if deleted
    public boolean deleteStudent(int id) {
        // Iterate using index so we can remove by index safely
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i); // remove the student at index i
                return true; // deletion successful
            }
        }
        return false; // student not found
    }
}
