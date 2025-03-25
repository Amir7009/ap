package ap.exercises.ex1.Ch6.E.E6_3;

import java.util.Scanner;

public class E6_3 {
    public static void main(String[] args) {
        String text;
        char[] textChar;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a string line: ");
        text = input.nextLine();
        textChar = text.toCharArray();
        // part a
        System.out.println("Part a: ");
        for (int i=0 ; i < textChar.length ; i++){
            if ( Character.isUpperCase(textChar[i]) )
                System.out.print(textChar[i]+"\t");
        }
        // part b
        /* I don't understand what question mean.
        So I wrote just characters with even index.*/
        System.out.println("\nPart b: ");
        for (int i=1 ; i < textChar.length ; i+=2 )
            System.out.print(textChar[i]+" ");
        //part c , d
        int cnt = 0;
        System.out.println("\nPart c: ");
        for (int i=0 ; i < textChar.length ; i++){
            int ch = textChar[i];
            switch (ch){
                case 65:
                case 97:
                case 69:
                case 101:
                case 73:
                case 105:
                case 79:
                case 111:
                case 85:
                case 117:
                    textChar[i] = '_';
                    cnt++;
                    break;
            }
        }
        System.out.print(textChar);
        System.out.println("\nPart d: ");
        System.out.println("count of vowels: " + cnt);
        // part e
        char[] tmp = text.toCharArray();
        System.out.println("\nPart e: ");
        for (int i=0 ; i < tmp.length ; i++){
            int ch = tmp[i];
            switch (ch){
                case 65:
                case 97:
                case 69:
                case 101:
                case 73:
                case 105:
                case 79:
                case 111:
                case 85:
                case 117:
                    System.out.println("index of " + tmp[i] + " is: " + i);
                    break;
            }
        }
        System.out.println(tmp);
    }
}
