package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students;
    private final FileStorage fileStorage;

    public StudentService() {
        this.fileStorage = new FileStorage("students.txt");
        this.students = new ArrayList<>(fileStorage.load());
    }

    public void saveData() {
        fileStorage.save(students);
    }

    private boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public boolean addStudent(Student student) {
        if (student == null || isNullOrEmpty(student.getId())) {
            return false;
        }

        if (findStudentById(student.getId()) != null) {
            return false;
        }

        students.add(student);
        return true;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(String id) {
        if (isNullOrEmpty(id)) {
            return null;
        }

        String normalizedId = id.trim();
        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(normalizedId)) {
                return student;
            }
        }

        return null;
    }

    public List<Student> findStudentsByName(String nameKeyword) {
        List<Student> results = new ArrayList<>();

        if (isNullOrEmpty(nameKeyword)) {
            return results;
        }

        String normalizedKeyword = nameKeyword.trim().toLowerCase();

        for (Student student : students) {
            String studentName = student.getName();
            if (studentName != null && studentName.toLowerCase().contains(normalizedKeyword)) {
                results.add(student);
            }
        }

        return results;
    }

    public boolean updateStudent(String id, Student newData) {
        if (newData == null) {
            return false;
        }

        Student existingStudent = findStudentById(id);
        if (existingStudent == null) {
            return false;
        }

        existingStudent.setName(newData.getName());
        existingStudent.setAge(newData.getAge());
        return true;
    }

    public boolean deleteStudent(String id) {
        Student student = findStudentById(id);
        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }
}
