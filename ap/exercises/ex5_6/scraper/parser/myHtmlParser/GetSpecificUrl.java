package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

import ap.exercises.ex5_6.scraper.Conf;
import ap.exercises.ex5_6.scraper.utils.DirectoryTools;
import ap.exercises.ex5_6.scraper.utils.FileTools;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetSpecificUrl {

    static List<String> fileList = DirectoryTools.getFilesAbsolutePathInDirectory(Conf.HTML_SAVE_DIRECTORY);

    private static Stream<String> getAllUrls() {
        return fileList.stream()
                .map(fileAddress -> FileTools.getTextFileLines(fileAddress))
                .filter(s -> s != null)
                .flatMap(s -> s.stream());
    }

    public static List<String> getImageUrl(){

        return getAllUrls().map(s -> ImageUrlParser.getImageUrl(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .distinct()
                .collect(Collectors.toList());

    }
    public static List<String> getMp3Url(){

        return getAllUrls().map(s -> MP3UrlParser.getMp3Url(s))
                .filter(s -> s != null)
                .filter(s -> s.length() > 1)
                .distinct()
                .collect(Collectors.toList());

    }

}
