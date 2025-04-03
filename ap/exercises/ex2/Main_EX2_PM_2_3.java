package ap.exercises.ex2;

import java.io.*;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {

    public static void main(String[] args) throws IOException {
        File file = new File("output.txt");
        file.createNewFile(); // Create backup file.
        Scanner text = new Scanner(new File("output.txt"));
        Scanner input = new Scanner(System.in);
        int k; // Common parameters
        char[][] map;
        int i, j;
        boolean exit;
        int points;
        int c;
        int timeSpent;

        if (text.hasNext()){ // Load game
            System.out.println("Loading game...\nFor save and quit press Q.\nMove the pacman with A, W, S, D");
            k = text.nextLine().length();
            c = text.nextLine().length();
            points = text.nextLine().length();
            i = text.nextLine().length();
            j = text.nextLine().length();
            timeSpent = text.nextLine().length();
            exit = false;
            // Load map
            map = new char[k + 2][k + 2];
            for(int x=0 ; x < k+2 ; x++) {
                for (int y = 0; y < k + 2; y++) {
                    String o = text.nextLine();
                    map[x][y] = o.charAt(0);
                }
            }
            printMap(map);
        }
        else { // Create new game
            // Get map size
            System.out.println("Please enter map size (k):");
            k = 0;
            while (k < 1) {
                k = input.nextInt();
                if (k < 1)
                    System.out.println("Error!\nPlease try again.");
            }
            // Design map
            map = new char[k + 2][k + 2];
            for (int p = 0; p < k + 2; p++) {
                map[0][p] = '*';
            }
            for (int p = 0; p < k + 2; p++) {
                map[k + 1][p] = '*';
            }
            for (int p = 0; p < k + 2; p++) {
                map[p][0] = '*';
            }
            for (int p = 0; p < k + 2; p++) {
                map[p][k + 1] = '*';
            }
            for (int p = 1; p < k + 1; p++) {
                for (int o = 1; o < k + 1; o++) {
                    map[p][o] = ' ';
                }
            }
            // Declare the pack-man
            i = 1;
            j = 1;
            map[i][j] = 'X';
            printMap(map);

            // Distribute points
            System.out.println("Please enter number of points: ");
            c = k * k;
            while (c > k * k - 1) { // -1 for X position
                c = input.nextInt();
                if (c > k * k - 1)
                    System.out.println("Error!\nPlease try again.");
            }
            points = 0;
            while (points < c) {
                int m = (int) (Math.random() * k + 1);
                int n = (int) (Math.random() * k + 1);
                if (map[m][n] == ' ') {
                    map[m][n] = '.';
                    points++;
                }
            }
            printMap(map);
            System.out.println("Move the pacman with A, W, S, D");
            System.out.println("For save and quit press Q.");

            // Exit and save kit
            exit = false;
            timeSpent = 0;
        }
        // Movement by keys
        char s;
        String enter; // for get input and change it to char type
        long start = System.currentTimeMillis(); // for playing time
        long finish;
        while (true){
            if (points == 0 || exit) {
                finish = System.currentTimeMillis();
                break;
            }
            enter = input.next();
            s = enter.charAt(0);
            switch (s) {
                case 'w': {
                    System.out.println("\nUP");
                    if (i - 1 != 0) {
                        i--;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i + 1][j];
                        map[i + 1][j] = ' ';
                        printMap(map);
                    } else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                }
                case 'd': {
                    System.out.println("\nRIGHT");
                    if (j + 1 != k + 1) {
                        j++;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i][j - 1];
                        map[i][j - 1] = ' ';
                        printMap(map);
                    } else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                }
                case 's': {
                    System.out.println("\nDOWN");
                    if (i + 1 != k + 1) {
                        i++;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i - 1][j];
                        map[i - 1][j] = ' ';
                        printMap(map);
                    } else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                }
                case 'a': {
                    System.out.println("\nLEFT");
                    if (j - 1 != 0) {
                        j--;
                        if (map[i][j] == '.')
                            points--;
                        map[i][j] = map[i][j + 1];
                        map[i][j + 1] = ' ';
                        printMap(map);
                    } else {
                        System.out.println("hitting the game wall\n");
                    }
                    break;
                }
                case 'q':{
                    exit = true;
                    break;
                }
                default: {
                    System.out.println("\nWARNING\nPlease try again\n");
                }
            }
        }
        System.out.println("your score: " + (c-points));
        System.out.println("your total playing time: " + ((float)( finish - start)/1000 + (float)(timeSpent)) + " seconds.");
        timeSpent = (int)( finish - start)/1000 + (timeSpent);
        // saving game
        if ( points != 0 ) {
            try {
                PrintWriter out = new PrintWriter("output.txt");
                for(int o=0 ; o < k ;  o++)
                    out.print(1);
                out.print("\n");
                for(int o=0 ; o < c ;  o++)
                    out.print(1);
                out.print("\n");
                for(int o=0 ; o < points ;  o++)
                    out.print(1);
                out.print("\n");
                for(int o=0 ; o < i ;  o++)
                    out.print(1);
                out.print("\n");
                for(int o=0 ; o < j ;  o++)
                    out.print(1);
                out.print("\n");
                for(int o=0 ; o < timeSpent ;  o++)
                    out.print(1);
                out.print("\n");
                for (char[] row : map) {
                    for (char v : row)
                        out.print(v + "\n");
                }
                out.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                FileWriter fileWriter = new FileWriter("output.txt", false);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        input.close();
        text.close();
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