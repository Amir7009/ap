package ap.projects.midtermProject.services.storage.tabSplit;

import ap.projects.midtermProject.models.borrowSystem.Borrow;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class TabSplitBorrowIO {

    public static void save(ArrayList<Borrow> borrows, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Borrow borrow : borrows)
                pw.println(borrow.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing borrows to TabSplit: " + e.getMessage());
        }
    }

    public static ArrayList<Borrow> load(String fileName) {

        ArrayList<Borrow> list = new ArrayList<>();

        try {

            for(String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())){

                String[] items = line.split("\t");
                Borrow borrow = new Borrow(
                        items[0],
                        items[1],
                        items[2],
                        LocalDate.parse(items[3]),
                        LocalDate.parse(items[4])
                );
                borrow.setActualReturnDate(LocalDate.parse(items[5]));
                borrow.setReclaimerLibrarianID(items[6]);

                list.add(borrow);
            }


        } catch (IOException e) {
            System.err.println("Error reading borrows from TabSplit: " + e.getMessage());
            return list;
        }

        return list;
    }

}
