package ap.projects.midtermProject.services.storage.json;

import ap.projects.midtermProject.models.Librarian;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;

public class JsonLibrarianIO {

    public static void save(LinkedHashMap<String, Librarian> librarians, String fileName) {
        JSONArray array = new JSONArray();
        for (Librarian l : librarians.values()) {
            JSONObject obj = new JSONObject();
            obj.put("employeeID", l.getEmployeeID());
            obj.put("firstName", l.getFirstName());
            obj.put("lastName", l.getLastName());
            obj.put("nationalID", l.getNationalID() != null ? l.getNationalID() : "");
            obj.put("address", l.getAddress() != null ? l.getAddress() : "");
            obj.put("educationLevel", l.getEducationLevel() != null ? l.getEducationLevel() : "");
            obj.put("phoneNumber", l.getPhoneNumber() != null ? l.getPhoneNumber() : "");
            obj.put("receiveReport", l.getReceiveReport() != null ? l.getReceiveReport() : "");
            obj.put("lendReport", l.getLendReport() != null ? l.getLendReport() : "");
            array.put(obj);
        }
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(array.toString(4));
        } catch (IOException e) {
            System.err.println("Error writing librarians to JSON: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Librarian> load(String fileName) {
        LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();
        File file = new File(fileName);
        if (!file.exists()) return librarians;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading librarians from JSON: " + e.getMessage());
            return librarians;
        }

        JSONArray array = new JSONArray(jsonText.toString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Librarian l = new Librarian(
                    obj.getString("employeeID"),
                    obj.getString("firstName"),
                    obj.getString("lastName"),
                    obj.optString("lendReport", ""),
                    obj.optString("receiveReport", "")
            );
            l.setNationalID(obj.optString("nationalID", ""));
            l.setAddress(obj.optString("address", ""));
            l.setEducationLevel(obj.optString("educationLevel", ""));
            l.setPhoneNumber(obj.optString("phoneNumber", ""));
            librarians.put(l.getEmployeeID(), l);
        }
        return librarians;
    }
}