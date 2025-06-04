package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

import ap.exercises.ex5_6.scraper.Conf;
import ap.exercises.ex5_6.scraper.utils.DirectoryTools;
import ap.exercises.ex5_6.scraper.utils.FileTools;

import java.util.List;
import java.util.stream.Collectors;

public class GetImagesUrl {

    static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.SAVE_DIRECTORY);

    public static List<String> getAllUrls() {
        List<String> urls = fileList.stream()
                .map(fileAddress -> FileTools.getTextFileLines(fileAddress))
                .filter(s -> s != null)
                .flatMap(s -> s.stream())
                .map(s -> MyHtmlParser.getFirstUrl(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .distinct()
                .collect(Collectors.toList());
        return urls;
    }

}
