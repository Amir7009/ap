package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

public class MP3UrlParser {

    public static String getMp3Url(String htmlLine) {
        String url = null;
        int endIndex = htmlLine.indexOf(".mp3");
        if (endIndex < 0){
            endIndex = htmlLine.indexOf(".MP3");
        }
        if (endIndex >= 0 && htmlLine.contains("href=\"")) {
            try {
                int startIndex = htmlLine.indexOf("=\"") + 2;
                url = htmlLine.substring(startIndex, endIndex + 4);
            } catch (Exception e) {
            }
        }
        return url;
    }

}
