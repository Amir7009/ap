package ap.projects.finalProject.util;

import java.util.Scanner;

public class UserInput {

    private Scanner scanner = new Scanner(System.in);

    /**
     * For switch cases of a UI menu.
     *
     * @param min the first option of menu
     * @param max the last option of menu
     * @return the chosen option by user
     */
    public int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }

}
