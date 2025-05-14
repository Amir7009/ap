package ap.midterm_project.helpers;

import java.util.Scanner;

public class InputHandler{

    Scanner scanner = new Scanner(System.in);
    Validator validate = new Validator();

    public byte switcher(){

        try {

            return scanner.nextByte();

        }catch (Exception e){

            System.out.println("Invalid option!");
            scanner.nextLine();
            return -1;

        }

    }

    public String userInput(String condition, String exception) {

        Scanner input = new Scanner(System.in);
        String temp;
        while (true) {

            temp = input.nextLine();
            if (validate.Validate(temp, condition)) {
                return temp;
            } else
                System.out.println(exception);

        }

    }

}
