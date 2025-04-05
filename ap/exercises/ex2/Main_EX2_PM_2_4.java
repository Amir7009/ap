package ap.exercises.ex2;

import java.io.*;
import java.util.*;

public class Main_EX2_PM_2_4 {

    public static void main(String[] args) {

        int k=9; //عدد مربوط به تمرین EX2_PM_1_1 و EX2_PM_1_2
        int c=15; //عدد مربوط به تمرین EX2_PM_1_3

        Random rnd = new Random();

        PacmanEngine pacmanEngine = new PacmanEngine(k,c);

        while(true) {
            pacmanEngine.printMatrix(); // مربوط به بخش آخر تمرین EX2_PM_1_3
            pacmanEngine.printScore(); // امتیاز تمرین EX2_PM_2_2
            pacmanEngine.printRemainTime(); // زمان تمرین EX2_PM_2_2

            try {
                Thread.sleep(2000);
            } catch (Exception e) {}

            int direction=rnd.nextInt(4);
            pacmanEngine.move(direction);// حرکت نقطه خوار مربوط به تمرین EX2-PM.1.5
            pacmanEngine.save();
        }

    }
}

class PacmanEngine {
    int k, c, points;
    char[][] map;
    int i=1, j=1;
    long start, finish;
    int timeSpent;
    File file = new File("output.txt");

    public PacmanEngine (int x, int y) {
        k = x; c = y;
        map = new char[k+2][k+2];
        designMap(k, map, c);
        createBackupFile();
        start = System.currentTimeMillis();
    }

    private void designMap(int k, char[][] map, int c) {
        for (int i = 0 ; i < k+2 ; i++) { // Map
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

        map[i][j] = 'X'; // pacman

        points = 0;
        while ( points < c ){
            int m = (int)(Math.random()*k+1);
            int n = (int)(Math.random()*k+1);
            if ( map[m][n] == ' ' ){
                map[m][n] = '.';
                points++;
            }
        }
    }

    private void createBackupFile() {
        try {
            file.createNewFile(); // Create backup file.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printMatrix(){
        for (char[] row : map) {
            for (char i : row)
                System.out.print(i);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void printScore(){
        System.out.println("Score: " + (c-points));
    }

    public void printRemainTime(){
        finish = System.currentTimeMillis();
        System.out.println("Remain time: " + (float)(finish-start)/1000 + " seconds");
        timeSpent = (int)((finish-start)/1000);
    }

    public void move(int s){
        switch (s) {
            case 0:
                System.out.println("\nUP");
                if( i-1 != 0 ) {
                    i--;
                    if (map[i][j] == '.')
                        points--;
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = ' ';
                }
                else {
                    System.out.println("hitting the game wall");
                }
                break;
            case 1:
                System.out.println("\nRIGHT");
                if ( j+1 != k+1 ) {
                    j++;
                    if (map[i][j] == '.')
                        points--;
                    map[i][j] = map[i][j - 1];
                    map[i][j - 1] = ' ';
                }
                else {
                    System.out.println("hitting the game wall");
                }
                break;
            case 2:
                System.out.println("\nDOWN");
                if ( i+1 != k+1 ) {
                    i++;
                    if (map[i][j] == '.')
                        points--;
                    map[i][j] = map[i - 1][j];
                    map[i - 1][j] = ' ';
                }
                else {
                    System.out.println("hitting the game wall");
                }
                break;
            case 3:
                System.out.println("\nLEFT");
                if ( j-1 != 0 ) {
                    j--;
                    if (map[i][j] == '.')
                        points--;
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = ' ';
                }
                else {
                    System.out.println("hitting the game wall");
                }
                break;
            default:
                System.out.println("WARNING");
        }
    }

    public void save(){
        try {
            FileWriter fileWriter = new FileWriter("output.txt", false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

}


