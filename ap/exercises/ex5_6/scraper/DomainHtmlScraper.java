package ap.exercises.ex5_6.scraper;

import ap.exercises.ex5_6.scraper.fetcher.HtmlFetcher;
import ap.exercises.ex5_6.scraper.parser.HtmlParser;
import ap.exercises.ex5_6.scraper.store.HtmlFileManager;

import java.io.IOException;
import java.util.*;

public class DomainHtmlScraper {
    private String domainAddress;
    private Queue<String> queue;

    private HtmlFileManager htmlFileManager;

    public DomainHtmlScraper(String domainAddress, String savePath) {
        this.domainAddress = domainAddress;
        this.queue = new LinkedList<>();
        this.htmlFileManager=new HtmlFileManager(savePath);
    }

    public void start() throws IOException {
        List<String> htmlLines = HtmlFetcher.fetchHtml(domainAddress);
//        this.htmlFileManager.save(htmlLines);

        // get domainCondition
        String domainCondition = Conf.getDomain(domainAddress);

        List<String> urls = HtmlParser.getAllUrlsFromList(htmlLines, domainCondition);
        queue.addAll(new HashSet<>(urls));
        int counter=1;

        while (!queue.isEmpty()){
            String url = queue.remove();
            counter++;
            try {
                htmlLines = HtmlFetcher.fetchHtml(url);
                this.htmlFileManager.save(htmlLines, url, domainCondition);

                urls = HtmlParser.getAllUrlsFromList(htmlLines, domainCondition);
                queue.addAll(new HashSet<>(urls));
            }
            catch (Exception e){
                System.out.println("ERROR: "+url+"\t -> "+e.getMessage());
            }
            System.out.println("["+counter+"] "+url+" fetch and saved (queue size:"+queue.size()+").");
        }
        System.out.println("Operation complete");
    }

}