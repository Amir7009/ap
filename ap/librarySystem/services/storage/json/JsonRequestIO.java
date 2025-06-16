package ap.librarySystem.services.storage.json;

import ap.librarySystem.constants.RequestType;
import ap.librarySystem.models.borrowSystem.Request;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;

public class JsonRequestIO {

    public static void save(ArrayList<Request> requests, String fileName) {
        JSONArray array = new JSONArray();
        for (Request r : requests) {
            JSONObject obj = new JSONObject();
            obj.put("borrowerStudentID", r.getBorrowerStudentID());
            obj.put("borrowedBookISBN", r.getBorrowedBookISBN());
            obj.put("librarianID", r.getLibrarianID());
            obj.put("requestType", r.getRequestType().toString());
            array.put(obj);
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(array.toString(4));
        } catch (IOException e) {
            System.err.println("Error writing requests to JSON: " + e.getMessage());
        }
    }

    public static ArrayList<Request> load(String fileName) {
        ArrayList<Request> requests = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return requests;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading requests from JSON: " + e.getMessage());
            return requests;
        }

        JSONArray array = new JSONArray(jsonText.toString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Request r = new Request(
                    obj.getString("borrowerStudentID"),
                    obj.getString("borrowedBookISBN"),
                    RequestType.valueOf(obj.getString("requestType")),
                    obj.getString("librarianID")
            );
            requests.add(r);
        }

        return requests;
    }
}
