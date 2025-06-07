package ap.exercises.ex5_6.scraper.fetcher;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ImageDownloader {

    /**
     * Downloads an image from a URL and saves it to the specified file path
     *
     * @param imageUrl URL of the image to download
     * @param outputPath Path where to save the image (including filename and extension)
     * @throws IOException If there's an error during download or file saving
     */
    public static void downloadImage(String imageUrl, String outputPath) throws IOException {
        // Validate inputs
        if (imageUrl == null || imageUrl.isBlank()) {
            throw new IllegalArgumentException("Image URL cannot be null or empty");
        }
        if (outputPath == null || outputPath.isBlank()) {
            throw new IllegalArgumentException("Output path cannot be null or empty");
        }

        URL url = new URL(imageUrl);
        try (InputStream in = url.openStream()) {
            Path output = Path.of(outputPath);
            try {
                // Create parent directories if they don't exist
                Files.createDirectories(output.getParent());
                // Download and save the file
            }
            catch (Exception e){}
            Files.copy(in, output, StandardCopyOption.REPLACE_EXISTING);
        }

    }

}