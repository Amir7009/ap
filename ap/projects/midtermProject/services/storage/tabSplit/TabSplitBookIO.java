package ap.projects.midtermProject.services.storage.tabSplit;

import ap.projects.midtermProject.constants.BookStatus;
import ap.projects.midtermProject.models.Book;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TabSplitBookIO {


    public static void save(LinkedHashMap<String, Book> books, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Book book : books.values())
                pw.println(book.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing books to TabSplit: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Book> load(String fileName) {

        LinkedHashMap<String, Book> books = new LinkedHashMap<>();
        ArrayList<Book> list;

        try {
            list = new ArrayList<>(Files.lines(Paths.get(fileName))
                    .map(s -> s.split("\t"))
                    .map(s -> new Book(s[0], s[1], s[2], s[3], s[4], BookStatus.valueOf(s[5])))
                    .toList());

        } catch (IOException e) {
            System.err.println("Error reading books from TabSplit: " + e.getMessage());
            return books;
        }

        for (Book item : list)
            books.put(item.getISBN(), item);

        return books;
    }

}
