package service;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public boolean addStudent(Student student) {
        if (student == null || student.getId() == null || student.getId().trim().isEmpty()) {
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
        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Student student : students) {
            if (student.getId().equalsIgnoreCase(id.trim())) {
                return student;
            }
        }

        return null;
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
