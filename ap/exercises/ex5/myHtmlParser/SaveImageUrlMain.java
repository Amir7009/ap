package ap.exercises.ex5.myHtmlParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveImageUrlMain {

    public static void main(String[] args) throws FileNotFoundException {

        String saveUrlPath = "E:\\Java\\Advanced-Programming\\ap\\exercises\\ex5\\myHtmlParser\\imageUrls.txt";
        PrintWriter printWriter = new PrintWriter(saveUrlPath);

        System.out.println("this urls are saved!\n");
        for (String i : GetPngUrl.getAllUrls()) {
            System.out.println(i);
            printWriter.println(i);
        }

        printWriter.close();
    }

}
