package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.repository.StudentRepository;

public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * after authenticating a student by AuthService registers the student in Library
     * @see AuthService
     * @param name student fullName
     * @param studentId student ID in the University
     * @param username the username of student
     * @param password the password of student
     */
    public void registerStudent(String name, String studentId, String username, String password) {
        if (repository.findByUsername(username) != null) {
            System.out.println("Registration failed! the username already exists.");
            return;
        }
        Student student = new Student(name, studentId, username, password);
        repository.add(student);
        System.out.println("Registration successful!");
    }

    /**
     * considers the input with students info
     * @param username the input username of user
     * @param password the input password of user
     * @return the student who registered successfully
     */
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
