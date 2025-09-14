package ap.projects.finalProject.storage.tabSplit;

import ap.projects.finalProject.model.Librarian;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TabSplitLibrarianIO {

    public static void save(LinkedHashMap<String, Librarian> librarians, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Librarian librarian : librarians.values())
                pw.println(librarian.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing librarians to TabSplit: " + e.getMessage());
        }
    }

    public static LinkedHashMap<String, Librarian> load(String fileName) {

        LinkedHashMap<String, Librarian> librarians = new LinkedHashMap<>();

        try {

            for(String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())){

                String[] items = line.split("\t");
                Librarian librarian = new Librarian(items[0], items[1]);
                librarian.setBooksRegisteredHistory(items[2]);
                librarian.setBooksRegisteredCount(Integer.parseInt(items[3]));
                librarian.setLentBooksCount(Integer.parseInt(items[4]));
                librarian.setReclaimedBooksCont(Integer.parseInt(items[5]));

                librarians.put(librarian.getEmployeeID(), librarian);
            }


        } catch (IOException e) {
            System.err.println("Error reading librarians from TabSplit: " + e.getMessage());
            return librarians;
        }

        return librarians;
    }

}
