package ap.exercises.ex5_6.myHtmlParser;

public class MyHtmlParser {

    public static String getFirstUrl(String htmlLine) {
        String url = null;
        int endIndex = htmlLine.indexOf(".png");
        if (endIndex < 0){
            endIndex = htmlLine.indexOf(".jpg");
        } // I think this two formats are enough.
        if (endIndex >= 0) {
            try {
                int startIndex = htmlLine.indexOf("\"", htmlLine.indexOf("="), endIndex);
                url = htmlLine.substring(startIndex + 1, endIndex + 4);
            } catch (Exception e) {
            }
        }
        return url;
    }

}
