package ap.exercises.Ch6.E.E6_8;

import java.util.Scanner;

public class E6_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = input.nextLine();
        String[] s = str.split("");
        for (String i : s)
            System.out.println(i);
    }
}
