package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

public class ImageUrlParser {

    public static String getImageUrl(String htmlLine) {
        String url = null;
        int endIndex = htmlLine.indexOf(".png");
        if (endIndex < 0){
            endIndex = htmlLine.indexOf(".jpg");
        } // I think this two formats are enough.
        if (endIndex >= 0 && (htmlLine.contains("src=\"") || htmlLine.contains("href\""))) {
            try {
                int startIndex = htmlLine.indexOf("=\"") + 2;
                url = htmlLine.substring(startIndex, endIndex + 4);
            } catch (Exception e) {
            }
        }

        return url;
    }

}
