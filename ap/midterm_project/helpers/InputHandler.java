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

        String temp;
        while (true) {

            temp = scanner.nextLine();
            if (validate.Validate(temp, condition)) {
                return temp;
            } else
                System.out.println(exception);

        }

    }

    public boolean yesOrNo(){

        String temp = scanner.nextLine();
        temp = temp.toLowerCase();
        if (temp.contains("y"))
            return true;
        else
            return false;

    }

}
