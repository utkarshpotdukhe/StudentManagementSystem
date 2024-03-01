import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

    // Constructor
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> studentList;

    // Constructor
    public StudentManagementSystem() {
        this.studentList = new ArrayList<>();
    }

    // Add student
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("Student added successfully.");
    }

    // Delete student
    public void deleteStudent(int studentId) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == studentId) {
                iterator.remove();
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found with ID: " + studentId);
    }

    // Display all students
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student List:");
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    sms.addStudent(new Student(name, id));
                    break;
                case 2:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 3:
                    sms.displayStudents();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
