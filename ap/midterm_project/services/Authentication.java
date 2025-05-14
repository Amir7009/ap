package ap.midterm_project.services;

import ap.midterm_project.helpers.InputHandler;
import ap.midterm_project.models.UsernameInterface;
import ap.midterm_project.constants.ValidateRoles;
import ap.midterm_project.models.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Authentication {

    ValidateRoles condition = new ValidateRoles(); // for validate conditions
    InputHandler userInput = new InputHandler(); // To get data from input

    public void signUp(ArrayList<Student> students) {

        // declare temporary variables for keep student's info
        String firstName, lastName, studyingField, studentId;

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
        studentId = userInput.userInput(
                condition.ID_VALIDATE_CONDITION,
                "You are only allowed to use numbers."
        );

        System.out.println("\n---You signed up successfully---");

        System.out.println("Your student ID is your username.\n");

        // add a new student
        students.add(new Student(firstName, lastName, studyingField, studentId, date.format(timeFormat)));

    }

    public <T extends UsernameInterface> int signIn(ArrayList<T> users) {
        // returns the index of the signed-in user

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
        for (int i = 0; i < users.size(); i++){

            if (users.get(i).getUsername().equals(username)){

                return i;

            }

        }

        System.out.println("Username Not found!");
        return -1;

    }

}