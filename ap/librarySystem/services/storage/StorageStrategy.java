package ap.librarySystem.services.storage;

import ap.librarySystem.database.Library;

public interface StorageStrategy {

    /**
     * just for save data :/
     * @param library saves it in specified way to files
     */
    void saveAll(Library library);

    /**
     * loads data with by way that the program reads from config
     * @param lib to connect with instantiation in the MainLibrary class
       get library as argument because manager doesn't save and load in this way
     * @see ap.librarySystem.MainLibrary
     */
    void loadAll(Library lib);

}
