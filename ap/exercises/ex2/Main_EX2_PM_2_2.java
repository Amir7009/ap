package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_2_2 {

    public static void main(String[] args) {
        // Get map size
        System.out.println("Please enter k:");
        Scanner input = new Scanner(System.in);
        int k = 0;
        while ( k < 1 ){
            k = input.nextInt();
            if ( k < 1 )
                System.out.println("Error!\nPlease try again.");
        }
        // design map
        char[][] map = new char[k+2][k+2];
        for (int i = 0 ; i < k+2 ; i++) {
            map[0][i] = '*'; }
        for (int i = 0 ; i < k+2 ; i++) {
            map[k+1][i] = '*'; }
        for (int i = 0 ; i < k+2 ; i++) {
            map[i][0] = '*'; }
        for (int i = 0 ; i < k+2 ; i++) {
            map[i][k+1] = '*'; }
        for (int i = 1; i < k+1; i++) {
            for (int j = 1; j < k+1; j++) {
                map[i][j]= ' ';
            }
        }
        // declare the pack-man
        int i=1 , j=1;
        map[i][j] = 'X';
        printMap(map);

        // Distribute points
        System.out.println("Please enter number of points: ");
        int c = k*k;
        while ( c > k*k-1){ // -1 for X position
            c = input.nextInt();
            if ( c > k*k-1 )
                System.out.println("Error!\nPlease try again.");
        }
        int points = 0;
        while ( points < c ){
            int m = (int)(Math.random()*k+1);
            int n = (int)(Math.random()*k+1);
            if ( map[m][n] == ' ' ){
                map[m][n] = '.';
                points++;
            }
        }
        printMap(map);

        // movement by keys
        char s;
        String enter;
        long start = System.currentTimeMillis();
        long finish;
        while (true){
            if (points == 0) {
                finish = System.currentTimeMillis();
                break;
            }
            enter = input.next();
            s = enter.charAt(0);
            switch (s) {
                case 'w':
                    System.out.println("\nUP");
                    if( i-1 != 0 ) {
                        i--;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                case 'd':
                    System.out.println("\nRIGHT");
                    if ( j+1 != k+1 ) {
                        j++;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i][j - 1];
                        map[i][j - 1] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                case 's':
                    System.out.println("\nDOWN");
                    if ( i+1 != k+1 ) {
                        i++;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i - 1][j];
                        map[i - 1][j] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                case 'a':
                    System.out.println("\nLEFT");
                    if ( j-1 != 0 ) {
                        j--;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i][j + 1];
                        map[i][j + 1] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                default:
                    System.out.println("\nWARNING\nPlease try again\n");
            }
        }
        System.out.println("your score: " + c);
        System.out.println("your playing time: " + (float)( finish - start)/1000 + " seconds.");
    }
    static void printMap (char[][] map){
        for (char[] row : map) {
            for (char i : row)
                System.out.print(i);
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}