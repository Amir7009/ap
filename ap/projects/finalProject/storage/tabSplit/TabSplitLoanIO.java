package ap.projects.finalProject.storage.tabSplit;

import ap.projects.finalProject.model.Loan;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;

public class TabSplitLoanIO {

    public static void save(ArrayList<Loan> loans, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Loan loan : loans)
                pw.println(loan.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing loans to TabSplit: " + e.getMessage());
        }
    }

    public static ArrayList<Loan> load(String fileName) {

        ArrayList<Loan> list = new ArrayList<>();

        try {

            for (String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())) {

                String[] items = line.split("\t");
                Loan loan = new Loan(
                        items[0],
                        items[1],
                        items[2],
                        LocalDate.parse(items[3]),
                        LocalDate.parse(items[4])
                );
                loan.setActualReturnDate(LocalDate.parse(items[5]));
                loan.setReclaimerLibrarianID(items[6]);

                list.add(loan);
            }


        } catch (IOException e) {
            System.err.println("Error reading loans from TabSplit: " + e.getMessage());
            return list;
        }

        return list;
    }

}
