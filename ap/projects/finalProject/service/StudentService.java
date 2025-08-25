package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.repository.StudentRepository;

import java.util.Arrays;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * after authenticating a student by AuthService registers the student in Library
     *
     * @param name      student fullName
     * @param studentId student ID in the University
     * @param username  the username of student
     * @param password  the password of student
     * @see AuthService
     */
    public void registerStudent(String name, String studentId, String username, String password) {
        if (repository.findByUsername(username) != null) {
            System.out.println("Registration failed! the username already exists.");
            return;
        }
        Student student = new Student(name, studentId, username, password);
        repository.add(username, student);
        System.out.println("Registration successful!");
    }

    /**
     * compares the input with students info
     *
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

    /**
     * Prints student's all notifications
     */
    public void printNotifications(String username) {

        System.out.println(Arrays.toString(repository.findByUsername(username).getNotifications().split("-")));

    }

    /**
     * To exchange the list of member students
     *
     * @return the student repository services
     */
    public StudentRepository getRepository() {
        return repository;
    }

}
