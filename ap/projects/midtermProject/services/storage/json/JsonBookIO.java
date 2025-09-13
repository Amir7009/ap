package ap.projects.midtermProject.services.storage.json;

import ap.projects.midtermProject.constants.BookStatus;
import ap.projects.midtermProject.models.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;

public class JsonBookIO {

    public static void save(LinkedHashMap<String, Book> books, String fileName) {
        JSONArray array = new JSONArray();

        for (Book book : books.values()) {
            JSONObject obj = new JSONObject();
            obj.put("ISBN", book.getISBN());
            obj.put("title", book.getTitle());
            obj.put("author", book.getAuthor());
            obj.put("pages", book.getPages());
            obj.put("year", book.getYear());
            obj.put("bookStatus", book.getBookStatus().name());
            array.put(obj);
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(array.toString(4)); // pretty print
        } catch (IOException e) {
            System.err.println("Error writing books to JSON: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Book> load(String fileName) {
        LinkedHashMap<String, Book> books = new LinkedHashMap<>();
        File file = new File(fileName);
        if (!file.exists()) return books;

        StringBuilder jsonText = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading books from JSON: " + e.getMessage());
            return books;
        }

        JSONArray array = new JSONArray(jsonText.toString());
        for (int i = 0; i < array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);

            Book book = new Book(
                    obj.getString("title"),
                    obj.getString("author"),
                    obj.getString("pages"),
                    obj.getString("year"),
                    obj.getString("ISBN"),
                    BookStatus.valueOf(obj.getString("bookStatus"))
            );

            books.put(book.getISBN(), book);
        }

        return books;
    }
}
