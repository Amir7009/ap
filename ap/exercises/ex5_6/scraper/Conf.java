package ap.exercises.ex5_6.scraper;

public class Conf {

    public static final String DOMAIN_ADDRESS = "https://www.znu.ac.ir";

    public static final String HTML_SAVE_DIRECTORY = "E:\\Java\\Advanced-Programming\\ap\\exercises\\ex5_6\\scraper\\fetched_html";
    public static final String IMAGE_SAVE_DIRECTORY = "E:\\Java\\Advanced-Programming\\ap\\exercises\\ex5_6\\scraper\\fetched_image";
    public static final String SOUND_SAVE_DIRECTORY = "E:\\Java\\Advanced-Programming\\ap\\exercises\\ex5_6\\scraper\\fetched_mp3";

    public static String getDomain(String domainAddress){
        String domainCondition = domainAddress;
        if(domainAddress.contains("https://"))
            domainCondition = domainCondition.replace("https://", "");
        if(domainAddress.contains("http://"))
            domainCondition = domainCondition.replace("http://", "");
        if (domainAddress.contains("www."))
            domainCondition = domainCondition.replace("www.", "");

        return domainCondition;
    }

    public static final int delay = 2000;

}