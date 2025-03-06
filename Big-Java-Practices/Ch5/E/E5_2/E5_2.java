package Ch5.E.E5_2;

import java.util.Scanner;

public class E5_2 {
    public static void main(String[] args) {
        System.out.print("Enter a floating point number: ");
        double f;
        Scanner input = new Scanner(System.in);
        f = input.nextDouble();
        if (f == 0)
            System.out.println("Zero!");
        else {
            if (f > 0)
                System.out.println("Positive");
            else
                System.out.println("Negative");
            if ( Math.abs(f) < 1 )
                System.out.println("small");
            if ( Math.abs(f) > 1e6 )
                System.out.println("large");
        }
    }
}
