package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Student;

import java.util.*;

public class StudentRepository {

    private LinkedHashMap<String, Student> students = new LinkedHashMap<>();

    /**
     * a method for add a new student to registered students
     *
     * @param student  The last student to register
     * @param username the student's username
     */
    public void add(String username, Student student) {
        students.put(username, student);
    }

    /**
     * to search a student by its username
     *
     * @param username the username that entered by user
     * @return if student exists returns the student
     */
    public Student findByUsername(String username) {
        return students.getOrDefault(username, null);
    }

    /**
     * to access all students who registered in the library
     *
     * @return list of students who registered in the library
     */
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    /**
     * to access to count of students who registered in the library
     *
     * @return the count of students
     */
    public int count() {
        return students.size();
    }

}
