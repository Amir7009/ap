package ap.librarySystem.helpers;

import java.util.Scanner;

public class InputHandler{

    Scanner scanner = new Scanner(System.in);

    /**
     * Creating suitable options for switching between cases.
     * @return the switch option
     */
    public byte switcher(){

        try {

            return scanner.nextByte();

        }catch (Exception e){

            System.out.println("Invalid option!");
            scanner.nextLine();
            return -1;

        }

    }

    /**
     * It takes the data and conforms it according to the appropriate condition.
     * @param condition to validate data according to it.
     * @param exception the problem that occurs while validate data.
     * @return the correct input
     * @see Validator
     */
    public String userInput(String condition, String exception) {

        String temp;
        while (true) {

            temp = scanner.nextLine();
            if (Validator.Validate(temp, condition)) {
                return temp;
            } else
                System.out.println(exception);

        }

    }

    /**
     * returns yes in any close input to "yes" answer.
     * @return the result
     */
    public boolean yesOrNo(){

        String temp = scanner.nextLine();
        temp = temp.toLowerCase();
        return temp.contains("y");

    }

}
