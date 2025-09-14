package ap.projects.finalProject;

import ap.projects.finalProject.model.*;
import ap.projects.finalProject.storage.FileManager;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();

        Manager libraryManager = new Manager(
                "znu",
                "1234",
                "AmirHossein",
                "Mohebbi",
                "Diploma"
        );

        LibrarySystem librarySystem = new LibrarySystem(libraryManager);
        fileManager.loadLibrary(librarySystem);

        librarySystem.start();

        fileManager.saveLibraryToTabSplit(librarySystem);

    }

}
