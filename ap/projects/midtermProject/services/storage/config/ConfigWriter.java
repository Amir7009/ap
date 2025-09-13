package ap.projects.midtermProject.services.storage.config;

import java.io.IOException;

public class ConfigWriter {

    private static final String CONFIG_FILE = ".\\ap\\librarySystem\\services\\storage\\config\\config.txt";

    public static void writeStorageType(String dataSaveType){

        try (java.io.FileWriter writer = new java.io.FileWriter(CONFIG_FILE)) {
            writer.write("storage=" + dataSaveType);
        } catch (IOException e) {
            System.err.println("Error writing data save type to config: " + e.getMessage());
        }

    }

}
