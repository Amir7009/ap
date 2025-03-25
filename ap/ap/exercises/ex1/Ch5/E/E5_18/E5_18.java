package ap.exercises.Ch5.E.E5_18;

import java.util.Scanner;

public class E5_18 {
    public static void main(String[] args) {
        String str, tmp;
        String[] array;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three strings: ");
        str = input.nextLine();
        array = str.split(" ");
        int if1 = ( array[0].compareTo(array[1]));
        int if2 = ( array[0].compareTo(array[2]));
        int if3 = ( array[1].compareTo(array[2]));
        if ( if1 > 0 ) {
            tmp = array[0];
            array[0] = array[1];
            array[1] = tmp;
        }
        if ( if2 > 0 ) {
            tmp = array[0];
            array[0] = array[2];
            array[2] = tmp;
        }
        if ( if3 > 0 ) {
            tmp = array[1];
            array[1] = array[2];
            array[2] = tmp;
        }
        System.out.println(array[0] + "\n" + array[1] + "\n" + array[2]);
    }
}
