package ap.librarySystem;

import ap.librarySystem.constants.UserRoles;
import ap.librarySystem.controllers.SwitchHandler;
import ap.librarySystem.database.Library;
import ap.librarySystem.helpers.MenuHelper;
import ap.librarySystem.models.LibraryManager;
import ap.librarySystem.services.storage.FileManager;

public class MainLibrary {

    /*
    In The Name Of ALLAH, The Most Gracious, The Most Merciful.
     */

    public static void main(String[] args) {

        /*
          Instantiate the base of the entire library system
          name and manager can be dynamic or from config
         */
        Library library = new Library("ZNU");
        library.setLibraryManager("10203040",
                new LibraryManager(
                        "10203040",
                        "Amir Hossein",
                        "Mohebbi",
                        "Diploma"
                )
        );

        FileManager fileManager = new FileManager();
        fileManager.loadLibrary(library);
        // for first run of code this massage is normal : The system cannot find the file specified

        SwitchHandler switchHandler = new SwitchHandler(library);
        MenuHelper menu = new MenuHelper();

        // To ensure data is saved when the program closes unexpectedly.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("The program is shutting down. Saving data...");
            switchHandler.handSaveDataTypeMenu();
        }));

        while (true) {

            UserRoles user = switch (menu.userSelectionMenu()) {
                case 1 -> UserRoles.STUDENT;
                case 2 -> UserRoles.LIBRARIAN;
                case 3 -> UserRoles.MANAGER;
                case 0 -> UserRoles.EXIT;
                case -1 -> null;
                default -> UserRoles.INVALID_OPTION;
            };

            if (user != null)
                switchHandler.handleRoleMenu(user);

        }

    }

}
