package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class SaveImageUrlMain {

    public static void main(String[] args) throws FileNotFoundException {

        String saveUrlPath = "E:\\Java\\Advanced-Programming\\ap\\exercises\\ex5_6\\scraper\\parser\\myHtmlParser\\imageUrls.txt";
        PrintWriter printWriter = new PrintWriter(saveUrlPath);

        System.out.println("urls are saved to this location:\nex5_6\\scraper\\parser\\myHtmlParser\\imageUrls.txt");
        for (String i : GetImagesUrl.getAllUrls()) {
            printWriter.println(i);
        }

        printWriter.close();
    }

}
