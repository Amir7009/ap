package ap.exercises.ex1.Ch6.E.E6_9;

import java.util.Scanner;

public class E6_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String str = input.nextLine();
        String[] s = str.split("");
        for ( int i=s.length-1 ; i >= 0 ; i-- )
            System.out.print(s[i]);
    }
}
