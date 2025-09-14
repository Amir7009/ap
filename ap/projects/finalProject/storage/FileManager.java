package ap.projects.finalProject.storage;

import ap.projects.finalProject.LibrarySystem;

public class FileManager {

    TabSplitStorage file;

    public void saveLibraryToTabSplit(LibrarySystem librarySystem) {

        file = new TabSplitStorage();
        file.saveAll(librarySystem);

    }

    public void loadLibrary(LibrarySystem librarySystem) {

        file = new TabSplitStorage();
        file.loadAll(librarySystem);

    }

}
