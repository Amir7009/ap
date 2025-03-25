package ap.exercises.Ch5.E.E5_15;

import java.util.Scanner;

public class E5_15 {
    public static void main(String[] args) {
        System.out.print("Enter your income: ");
        Scanner input = new Scanner(System.in);
        double income;
        income = input.nextDouble();
        if ( income <= 50000 )
            System.out.println("You must pay " + (float)((income * 1)/100 ) + " dollars.");
        else if ( income <= 75000 )
            System.out.println("You must pay " + (float)((income * 2)/100 ) + " dollars.");
        else if ( income <= 100000 )
            System.out.println("You must pay " + (float)((income * 3)/100 ) + " dollars.");
        else if ( income <= 250000 )
            System.out.println("You must pay " + (float)((income * 4)/100 ) + " dollars.");
        else if ( income <= 500000 )
            System.out.println("You must pay " + (float)((income * 5)/100 ) + " dollars.");
        else
            System.out.println("You must pay " + (float)((income * 6)/100 ) + " dollars.");
    }
}
