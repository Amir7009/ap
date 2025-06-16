package ap.librarySystem.services.storage.tabSplit;

import ap.librarySystem.models.Librarian;

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
                Librarian librarian = new Librarian(
                        items[0],
                        items[1],
                        items[2],
                        items[3],
                        items[4]
                );
                librarian.setNationalID(items[5]);
                librarian.setAddress(items[6]);
                librarian.setEducationLevel(items[7]);
                librarian.setPhoneNumber(items[8]);

                librarians.put(librarian.getEmployeeID(), librarian);
            }


        } catch (IOException e) {
            System.err.println("Error reading librarians from TabSplit: " + e.getMessage());
            return librarians;
        }

        return librarians;
    }

}
