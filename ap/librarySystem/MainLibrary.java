package ap.librarySystem;

import ap.librarySystem.constants.UserRoles;
import ap.librarySystem.controllers.SwitchHandler;
import ap.librarySystem.database.Library;
import ap.librarySystem.models.LibraryManager;
import ap.librarySystem.services.MenuHelper;

public class MainLibrary {

    public static void main(String[] args) {

//        FileManager fileManager = new FileManager();
        Library library = new Library("ZNU");
        library.setLibraryManager("10203040",
                new LibraryManager(
                        "10203040",
                        "Amir Hossein",
                        "Mohebbi",
                        "Diploma"
                )
        );
//        fileManager.Load(library);
        MenuHelper menu = new MenuHelper();
        SwitchHandler switchHandler = new SwitchHandler(library);

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
