package service;

import model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    private final String filename;

    public FileStorage(String filename) {
        this.filename = filename;
    }

    public List<Student> load() {
        List<Student> students = new ArrayList<>();
        File file = new File(filename);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Student student = parseLine(line);
                if (student != null) {
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }

        return students;
    }

    public void save(List<Student> students) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : students) {
                writer.write(formatLine(student));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    private Student parseLine(String line) {
        String[] parts = line.split(",");
        if (parts.length != 3) {
            return null;
        }

        try {
            String id = parts[0].trim();
            String name = parts[1].trim();
            int age = Integer.parseInt(parts[2].trim());
            return new Student(id, name, age);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String formatLine(Student student) {
        return student.getId() + "," + student.getName() + "," + student.getAge();
    }
}
