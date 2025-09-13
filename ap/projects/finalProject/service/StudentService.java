package ap.projects.finalProject.service;

import ap.projects.finalProject.model.Student;
import ap.projects.finalProject.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * After authenticating a student by AuthService registers the student in Library
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
     * Compares the input with students info
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
    public void printNotifications(Student student) {

        String[] myNotifications = student.getNotifications().split("-");

        System.out.println("\n--- My Notifications ---\n");
        for (int i = myNotifications.length - 1; i >= 0; i--) {
            System.out.println(myNotifications[i]);
        }

    }

    /**
     * View a student's loan history along with the following statistical information:
     * Total number of loans
     * Total number of current loans
     * Total number of overdue loans
     */
    public void printStudentLoanStats() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Student's Username: ");
        Student student = this.repository.findByUsername(scanner.nextLine());

        String[] history = student.getLoanHistory().split("-");

        System.out.println("\n--- Student Loan Stats ---\n");

        System.out.println("All Returned Loans: " + student.getLoansCount());
        System.out.println("All Current Loans: " + student.getCurrentLoansCount());
        System.out.println("All Late Loans: " + student.getLateLoansCount());

        System.out.println("\n--- Student Loan History ---\n");
        for (int i = history.length - 1; i >= 0; i--) {
            System.out.println(history[i]);
        }

        scanner.close();

    }

    /**
     * The librarian can revoke access from a student.
     * A student who does not have access cannot register for a new loan.
     */
    public void setStudentStatus() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter The Student's Username: ");
        Student student = this.repository.findByUsername(scanner.nextLine());

        if (student.isActive())
            System.out.println("This Student Is Already Active. Do You Want To Change It? (y/n)");
        else
            System.out.println("This Student Is Already nonActive. Do You Want To Change It? (y/n)");

        String input = scanner.nextLine().toLowerCase();
        if (input.contains("y")) {
            student.setActive(!student.isActive());
            System.out.println("Successful!");
        }

    }

    public void printTopTenMostDelayed() {

        return;

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
