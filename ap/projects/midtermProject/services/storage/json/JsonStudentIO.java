package ap.projects.midtermProject.services.storage.json;

import ap.projects.midtermProject.models.Student;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;

public class JsonStudentIO {

    public static void save(LinkedHashMap<String, Student> students, String fileName) {
        JSONArray array = new JSONArray();
        for (Student s : students.values()) {
            JSONObject obj = new JSONObject();
            obj.put("firstName", s.getFirstName());
            obj.put("lastName", s.getLastName());
            obj.put("studyingField", s.getStudyingField());
            obj.put("studentID", s.getStudentID());
            obj.put("membershipDate", s.getMembershipDate());
            obj.put("notifications", s.getNotifications());
            obj.put("loanHistory", s.getLoanHistory());
            array.put(obj);
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(array.toString(4));
        } catch (IOException e) {
            System.err.println("Error writing students to JSON: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Student> load(String fileName) {
        LinkedHashMap<String, Student> students = new LinkedHashMap<>();
        File file = new File(fileName);
        if (!file.exists()) return students;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading students from JSON: " + e.getMessage());
            return students;
        }

        JSONArray array = new JSONArray(jsonText.toString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Student s = new Student(
                    obj.getString("firstName"),
                    obj.getString("lastName"),
                    obj.getString("studyingField"),
                    obj.getString("studentID"),
                    obj.getString("membershipDate"),
                    obj.getString("notifications"),
                    obj.getString("loanHistory")
            );
            students.put(s.getStudentID(), s);
        }
        return students;
    }
}
