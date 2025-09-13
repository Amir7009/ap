package ap.projects.midtermProject.services;

import ap.projects.midtermProject.constants.ValidateRoles;
import ap.projects.midtermProject.helpers.InputHandler;
import ap.projects.midtermProject.models.Librarian;

public class Editor {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler userInput = new InputHandler(); // To get data from input

    // for add librarians more info and edit
    public void editLibrarianInfo (Librarian librarian){

        System.out.println("Please enter your national ID: ");
        librarian.setNationalID(userInput.userInput(
                condition.ID_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        ));

        System.out.println("Please enter your address: ");
        librarian.setAddress( userInput.userInput(
                condition.TEXT_VALIDATE_CONDITION,
                "You are only allowed to use letters, numbers, punctuation marks."
        ));

        System.out.println("Please enter your last academic degree: ");
        librarian.setEducationLevel(userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        ));

        System.out.println("Please enter your phoneNumber (EX 09********): ");
        librarian.setPhoneNumber( userInput.userInput(
                condition.PHONE_NUMBER_VALIDATE_CONDITION,
                "You are only allowed to use numbers (11 digits)."
        ));

        System.out.println("\n---operation successfully---");

    }

}
