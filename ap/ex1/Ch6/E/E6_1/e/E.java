package Ch6.E.E6_1.e;

import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        int num, sum=0;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = input.nextInt();
        for ( int i = num ; i > 0 ; i /= 10 ) {
            int r;
            r = i%10;
            if ( r%2 != 0)
                sum += r;
        }
        System.out.println("sum= " + sum );
    }
}
