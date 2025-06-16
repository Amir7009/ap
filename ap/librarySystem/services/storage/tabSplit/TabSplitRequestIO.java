package ap.librarySystem.services.storage.tabSplit;

import ap.librarySystem.constants.RequestType;
import ap.librarySystem.models.borrowSystem.Request;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TabSplitRequestIO {

    public static void save(ArrayList<Request> requests, String fileName) {

        try (
                PrintWriter pw = new PrintWriter(new FileOutputStream(
                        fileName))
        ) {
            for (Request request : requests)
                pw.println(request.tabSplit());

        } catch (FileNotFoundException e) {
            System.err.println("Error writing requests to TabSplit: " + e.getMessage());
        }
    }

    public static ArrayList<Request> load(String fileName) {

        ArrayList<Request> list = new ArrayList<>();

        try {
            list = new ArrayList<>(Files.lines(Paths.get(fileName))
                    .map(s -> s.split("\t"))
                    .map(s -> new Request(s[0], s[1], RequestType.valueOf(s[2]), s[3]))
                    .toList());

        } catch (IOException e) {
            System.err.println("Error reading requests from TabSplit: " + e.getMessage());
            return list;
        }

        return list;
    }

}
