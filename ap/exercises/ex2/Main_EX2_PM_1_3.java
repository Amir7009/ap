package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_3 {

    public static void main(String[] args) {
        System.out.println("Please enter k:");
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();

        char[][] map = new char[k+2][k+2];
        for (int i = 0 ; i < k+2 ; i++) {
            map[0][i] = '*';
        }
        for (int i = 0 ; i < k+2 ; i++) {
            map[k+1][i] = '*';
        }
        for (int i = 0 ; i < k+2 ; i++) {
            map[i][0] = '*';
        }
        for (int i = 0 ; i < k+2 ; i++) {
            map[i][k+1] = '*';
        }
        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < k+1; j++) {
                map[i][j]= ' ';
            }
        }
        System.out.println("Please enter number of points: ");
        int c = k*k+1;
        while ( c > k*k){
            c = input.nextInt();
            if ( c > k*k )
                System.out.println("Error!\nPlease try again.");
        }
        int points = 0;
        while ( points < c ){
            int i = (int)(Math.random()*k+1);
            int j = (int)(Math.random()*k+1);
            if ( map[i][j] == ' ' ){
                map[i][j] = '.';
                points++;
            }
        }

        for (char[] row : map) {
            for (char i : row)
                System.out.print(i);
            System.out.print("\n");
        }
    }
}

