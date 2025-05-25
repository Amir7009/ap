package ap.midterm_project;

import ap.midterm_project.constants.UserRoles;
import ap.midterm_project.controllers.SwitchHandler;
import ap.midterm_project.database.Library;
import ap.midterm_project.services.FileManager;
import ap.midterm_project.services.MenuHelper;

public class MainLibrary {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager();
        Library library = new Library("ZNU");
        fileManager.Load(library);
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
