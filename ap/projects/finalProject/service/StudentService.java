package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.repository.StudentRepository;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public boolean registerStudent(String name, String studentId, String username, String password) {
        if (repository.findByUsername(username) != null) {
            return false;
        }
        Student student = new Student(name, studentId, username, password);
        repository.add(student);
        return true;
    }

    public Student authenticateStudent(String username, String password) {
        Student student = repository.findByUsername(username);
        if (student != null && student.getPassword().equals(password)) {
            return student;
        }
        return null;
    }

    public int getStudentCount() {
        return repository.count();
    }
}
