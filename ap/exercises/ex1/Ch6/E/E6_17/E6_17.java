package ap.exercises.ex1.Ch6.E.E6_17;

import java.util.Scanner;

public class E6_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();
        for (int i=1 ; i <= n ; i++){
            for (int j=1 ; j <= 2*n+1 ; j++){
                if ( j <= n )
                    System.out.print(" * ");
                if ( j == n+1 )
                    System.out.print("   ");
                if ( j == n+2 || j == 2*n+1 )
                    System.out.print(" * ");
                if ( j > n+2 && j < 2*n+1 )
                    if ( i == 1 || i == n )
                        System.out.print(" * ");
                    else
                        System.out.print("   ");
            }
            System.out.print("\n");
        }
    }
}
