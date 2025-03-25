package ap.exercises.Ch6.E.E6_13;

import java.util.Scanner;

public class E6_13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i=n ; i > 0 ; i /= 2){
            System.out.println(i%2);
        }
        if (n == 0)
            System.out.println(0);
    }
}