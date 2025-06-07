package ap.exercises.ex5_6.scraper.parser.myHtmlParser;

import ap.exercises.ex5_6.scraper.Conf;
import ap.exercises.ex5_6.scraper.fetcher.ImageDownloader;
import ap.exercises.ex5_6.scraper.fetcher.MP3Downloader;

import java.io.IOException;

public class DownloadFileFromUrl {

    public static void main(String[] args) {

        System.out.println("This process may be take a few minutes!");

        int imageCounter = 0;
        for (String i : GetSpecificUrl.getImageUrl()) {
            try {
                Thread.sleep(Conf.delay);
                imageCounter++;
                ImageDownloader.downloadImage("https://www.znu.ac.ir/" + i,
                        Conf.IMAGE_SAVE_DIRECTORY + "\\" + imageCounter + ".png");
            } catch (IOException | InterruptedException e) {
                System.out.println("image: " + i + "\nnot found!");
            }
        }
        System.out.println("Images are downloaded.");

        int soundCounter = 0;
        for (String i : GetSpecificUrl.getMp3Url()) {
            try {
                Thread.sleep(Conf.delay);
                soundCounter++;
                MP3Downloader.downloadMP3(i,
                        Conf.SOUND_SAVE_DIRECTORY + "\\" + soundCounter + ".mp3");
            } catch (IOException | InterruptedException e) {
                System.out.println("sound: " + i + "\nnot found!");
            }
        }
        System.out.println("Sounds are downloaded.");

    }

}
