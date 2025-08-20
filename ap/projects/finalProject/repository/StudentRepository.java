package ap.projects.finalProject.repository;

import ap.projects.finalProject.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public Student findByUsername(String username) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    public int count() {
        return students.size();
    }
}