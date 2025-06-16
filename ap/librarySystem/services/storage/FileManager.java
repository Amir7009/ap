package ap.librarySystem.services.storage;

import ap.librarySystem.database.Library;
import ap.librarySystem.services.storage.config.ConfigReader;
import ap.librarySystem.services.storage.json.JsonStorageStrategy;
import ap.librarySystem.services.storage.sqlite.SqliteStorageStrategy;
import ap.librarySystem.services.storage.tabSplit.TabSplitStorageStrategy;

public class FileManager {

    StorageStrategy file;

    public void saveLibraryToJson(Library library) {

        file = new JsonStorageStrategy();
        file.saveAll(library);

    }

    public void saveLibraryToTabSplit(Library library) {

        file = new TabSplitStorageStrategy();
        file.saveAll(library);

    }

    public void saveLibraryToSqlite(Library library) {

        file = new SqliteStorageStrategy();
        file.saveAll(library);

    }

    public void loadLibrary(Library library) {

        switch (ConfigReader.readStorageType()){

            case "json" -> {

                file = new JsonStorageStrategy();
                file.loadAll(library);

            }

            case "tabsplit" -> {

                file = new TabSplitStorageStrategy();
                file.loadAll(library);

            }

            case "sqlite" -> {

                file = new SqliteStorageStrategy();
                file.loadAll(library);

            }

            case null -> {}

            default -> System.out.println("...ERROR...");

        }

    }

}
