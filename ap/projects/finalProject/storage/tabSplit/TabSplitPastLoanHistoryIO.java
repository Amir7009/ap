package ap.projects.finalProject.storage.tabSplit;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TabSplitPastLoanHistoryIO {

    public static void save(ArrayList<String> pastLoansHistory, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (String str : pastLoansHistory)
                pw.println(str);

        } catch (FileNotFoundException e) {
            System.err.println("Error writing past loans history to TabSplit: " + e.getMessage());
        }
    }

    public static ArrayList<String> load(String fileName) {

        ArrayList<String> pastLoansHistory = new ArrayList<>();

        try {

            for (String line : new ArrayList<>(Files.lines(Paths.get(fileName)).toList())) {

                String[] items = line.split("\t");
                pastLoansHistory.add(items[0]);

            }


        } catch (IOException e) {
            System.err.println("Error reading past loans history from TabSplit: " + e.getMessage());
            return pastLoansHistory;
        }

        return pastLoansHistory;
    }

}
