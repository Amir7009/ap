package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_5 {

    public static void main(String[] args) {
        // Get map size
        System.out.println("Please enter k:");
        Scanner input = new Scanner(System.in);
        int k = input.nextInt();
        // design map
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
        int i=1 , j=1;
        map[i][j] = 'X';
        printMap(map);

        // Random movement
        int h=5;
        while (--h >= 0){
            int s = (int)(Math.random()*4);
            switch (s) {
                case 0:
                    System.out.println("\nUP");
                    if( i-1 != 0 ) {
                        i--;
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall");
                    }
                    break;
                case 1:
                    System.out.println("\nRIGHT");
                    if ( j+1 != k+1 ) {
                        j++;
                        map[i][j] = map[i][j - 1];
                        map[i][j - 1] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall");
                    }
                    break;
                case 2:
                    System.out.println("\nDOWN");
                    if ( i+1 != k+1 ) {
                        i++;
                        map[i][j] = map[i - 1][j];
                        map[i - 1][j] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall");
                    }
                    break;
                case 3:
                    System.out.println("\nLEFT");
                    if ( j-1 != 0 ) {
                        j--;
                        map[i][j] = map[i][j + 1];
                        map[i][j + 1] = ' ';
                        printMap(map);
                    }
                    else {
                        System.out.println("hitting the game wall");
                    }
                    break;
                default:
                    System.out.println("WARNING");
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {}
        }
    }
    static void printMap (char[][] map){
        for (char[] row : map) {
            for (char i : row)
                System.out.print(i);
            System.out.print("\n");
        }
    }


}

