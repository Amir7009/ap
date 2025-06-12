package ap.librarySystem.services;

import ap.librarySystem.helpers.InputHandler;
import ap.librarySystem.models.UsernameInterface;
import ap.librarySystem.constants.ValidateRoles;
import ap.librarySystem.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;

public class Authentication {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler userInput = new InputHandler(); // To get data from input

    public void signUp(LinkedHashMap<String, Student> students) {

        // declare temporary variables for keep student's info
        String firstName, lastName, studyingField, studentID;

        // Time classes for Membership date
        LocalDate date = LocalDate.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

        System.out.println("======== WELCOME ========");

        // get student's first name from user
        System.out.println("Please enter your first name: ");
        firstName = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        // get student's last name from user
        System.out.println("Please enter your last name: ");
        lastName = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        // get student's national ID from user
        System.out.println("Please enter your studying field: ");
        studyingField = userInput.userInput(
                condition.NAME_VALIDATE_CONDITION,
                "You are only allowed to use letters."
        );

        // get student's ID from user
        System.out.println("Please enter your student ID: ");
        studentID = userInput.userInput(
                condition.ID_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        // add a new student
        if (!students.containsKey(studentID)) {
            students.put(studentID,
                    new Student(
                            firstName,
                            lastName,
                            studyingField,
                            studentID,
                            date.format(timeFormat),
                            "Massages",
                            "History"
                    )
            );

            System.out.println("\n---You signed up successfully---");
            System.out.println("Your student ID is your username.\n");

        }else {
            System.out.println("\n---sign up failed---");
            System.out.println("This student ID exists!");
        }

    }

    public <T extends UsernameInterface> String signIn(LinkedHashMap<String, T> users) {
        // returns the username of the signed-in user

        // declare temporary variable for keep username
        String username;

        System.out.println("======== WELCOME ========");

        // get username from user
        System.out.println("Please enter your username: ");
        username = userInput.userInput(
                condition.USERNAME_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        // search user in list
        if (users.containsKey(username))
            return username;

        System.out.println("Username Not found!");
        return null;

    }

}