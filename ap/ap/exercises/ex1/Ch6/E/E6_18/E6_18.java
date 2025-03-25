package ap.exercises.Ch6.E.E6_18;

import java.util.Scanner;

public class E6_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        for (int i=1 ; i < 2*n ; i++) {
            int z = n - Math.abs(n - i);
            for (int j=1 ; j < 2*n ; j++) {
                if ( j <= n-z || j > n+z-1)
                    System.out.print("   ");
                else
                    System.out.print(" * ");
            }
            System.out.print("\n");
        }
    }
}
