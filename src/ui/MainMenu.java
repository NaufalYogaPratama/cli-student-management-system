package ui;

import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private final StudentService studentService;
    private final Scanner scanner;

    public MainMenu(StudentService studentService) {
        this.studentService = studentService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            showMenu();
            String choice = readNonEmptyInput("Choose menu (1-3): ");

            switch (choice) {
                case "1":
                    addStudentMenu();
                    break;
                case "2":
                    viewStudentsMenu();
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, or 3.");
            }

            System.out.println();
        }
    }

    private void showMenu() {
        System.out.println("==== Student Management Menu ====");
        System.out.println("1. Add Student");
        System.out.println("2. View Students");
        System.out.println("3. Exit");
    }

    private void addStudentMenu() {
        System.out.println("\n-- Add Student --");

        String id = readNonEmptyInput("Input ID: ");
        String name = readNonEmptyInput("Input Name: ");
        int age = readPositiveAge("Input Age: ");

        Student student = new Student(id, name, age);
        boolean added = studentService.addStudent(student);

        if (added) {
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Failed to add student. Check ID (must be unique and not empty).");
        }
    }

    private void viewStudentsMenu() {
        System.out.println("\n-- Student List --");
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". " + student);
        }
    }

    private String readNonEmptyInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private int readPositiveAge(String prompt) {
        while (true) {
            System.out.print(prompt);
            String ageInput = scanner.nextLine().trim();

            if (ageInput.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
                continue;
            }

            try {
                int age = Integer.parseInt(ageInput);
                if (age > 0) {
                    return age;
                }
                System.out.println("Age must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Age must be a valid number.");
            }
        }
    }
}
