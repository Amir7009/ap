package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Student;
import java.util.*;

public class StudentRepository {

    private List<Student> students = new ArrayList<>();

    /**
     * a method for add a new student to registered students
     * @param student The last student to register
     */
    public void add(Student student) {
        students.add(student);
    }

    /**
     * to search a student by its username
     * @param username the username that entered by user
     * @return if student exists returns the student
     */
    public Student findByUsername(String username) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    /**
     * to access all students who registered in the library
     * @return list of students who registered in the library
     */
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    /**
     * to access to count students who registered in the library
     * @return the count of students
     */
    public int count() {
        return students.size();
    }

}
