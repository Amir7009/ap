package ap.projects.midtermProject.services.storage.json;

import ap.projects.midtermProject.models.borrowSystem.Borrow;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class JsonBorrowIO {

    public static void save(ArrayList<Borrow> borrows, String fileName) {
        JSONArray array = new JSONArray();
        for (Borrow b : borrows) {
            JSONObject obj = new JSONObject();
            obj.put("borrowerStudentID", b.getBorrowerStudentID());
            obj.put("borrowedBookISBN", b.getBorrowedBookISBN());
            obj.put("lenderLibrarianID", b.getLenderLibrarianID());
            obj.put("reclaimerLibrarianID", b.getReclaimerLibrarianID());
            obj.put("loanStartDate", b.getLoanStartDate().toString());
            obj.put("loanFinishDate", b.getLoanFinishDate().toString());
            obj.put("actualReturnDate", b.getActualReturnDate() != null ? b.getActualReturnDate().toString() : JSONObject.NULL);
            array.put(obj);
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(array.toString(4));
        } catch (IOException e) {
            System.err.println("Error writing borrows to Json: " + e.getMessage());
        }
    }

    public static ArrayList<Borrow> load(String fileName) {
        ArrayList<Borrow> borrows = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) return borrows;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading borrows from Json: " + e.getMessage());
            return borrows;
        }

        JSONArray array = new JSONArray(jsonText.toString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            Borrow b = new Borrow(
                    obj.getString("borrowerStudentID"),
                    obj.getString("borrowedBookISBN"),
                    obj.getString("lenderLibrarianID"),
                    LocalDate.parse(obj.getString("loanStartDate")),
                    LocalDate.parse(obj.getString("loanFinishDate"))
            );

            if (!obj.isNull("actualReturnDate")) {
                b.setActualReturnDate(LocalDate.parse(obj.getString("actualReturnDate")));
                b.setReclaimerLibrarianID(obj.optString("reclaimerLibrarianID", null));
            }

            borrows.add(b);
        }

        return borrows;
    }
}
