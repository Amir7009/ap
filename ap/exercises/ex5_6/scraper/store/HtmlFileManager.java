package ap.exercises.ex5_6.scraper.store;

import ap.exercises.ex5_6.scraper.Conf;
import ap.exercises.ex5_6.scraper.utils.DirectoryTools;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public class HtmlFileManager {

    private String saveFileBasePath;
    private static int saveCounter = 0;

    public HtmlFileManager(String saveFileBasePath) {
//        this.saveFileBasePath = DirectoryTools.createDirectoryWithTimeStamp(saveFileBasePath);

        this.saveFileBasePath = saveFileBasePath;
        DirectoryTools.createDirectory(saveFileBasePath);
    }

    public void save(List<String> lines, String url, String domain) {
        try {
            String saveHtmlFileAddress = getSaveHtmlFileAddress();
            PrintWriter out = new PrintWriter(saveHtmlFileAddress);
            for (String line : lines) {
                out.println(line);
            }
            out.close();

            // packaging html files
            String saveHtmlFilesToPackages = getActualSaveDirectoryAddress(url, domain);
            DirectoryTools.createDirectory(saveHtmlFilesToPackages);
            PrintWriter out2 = new PrintWriter(saveHtmlFilesToPackages + File.separator + saveCounter + ".html");
            for (String line : lines) {
                out2.println(line);
            }
            out2.close();

            System.out.println("save counter: " + saveCounter);
        } catch (Exception e) {
            System.out.println("save failed: " + e.getMessage());
        }
    }

    public String getSaveHtmlFileAddress() {
        saveCounter++;
        return saveFileBasePath + "/" + saveCounter + ".html";
    }

    public String getActualSaveDirectoryAddress(String url, String domain) {

        // get main path
        String mainPath = url
                .replace("https://", "")
                .replace("http://", "")
                .replace("www.", "");

        String finalPath = "";
        if (mainPath.contains("." + domain)) {
            finalPath = mainPath.substring(0, mainPath.indexOf("."));
            mainPath = mainPath.replace(finalPath + ".", "");
        }
        mainPath = mainPath.replace(domain, "");
        finalPath = "_" + finalPath.concat("/" + mainPath);

        finalPath = domain.replace(".", "-") + "/" +
                finalPath.replace(".", "_");

        return finalPath;
    }
}