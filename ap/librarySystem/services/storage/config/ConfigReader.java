package ap.librarySystem.services.storage.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    private static final String CONFIG_FILE = ".\\ap\\librarySystem\\services\\storage\\config\\config.txt";

    public static String readStorageType()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(CONFIG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("storage=")) {
                    return line.substring("storage=".length()).trim().toLowerCase();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Got an error before reading config file:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Got an error while reading config file:" + e.getMessage());
        }

        return null;

    }

}