package ap.exercises.ex1.Ch6.E.E6_2;

import java.util.Scanner;

public class E6_2 {
    public static void main(String[] args) {
        System.out.print("Enter the number of entries: ");
        Scanner input = new Scanner(System.in);
        int n, min, max, even=0, odd=0;
        n = input.nextInt();
        int[] myNums = new int[n];
        int[] partC = new int[n];
        System.out.println("Enter the numbers: ");
        myNums[0] = input.nextInt();
        min = max = myNums[0];
        if ( myNums[0]%2 == 0 )
            even++;
        else
            odd++;
        int[] partD = new int[n/2];
        int cnt=0;
        for ( int i=1 ; i < n ; i++ ) {
            myNums[i] = input.nextInt();
            if (myNums[i] > max)
                max = myNums[i];
            if (myNums[i] < min)
                min = myNums[i];
            if (myNums[i] % 2 == 0)
                even++;
            else
                odd++;
            boolean x = true;
            if (myNums[i] == myNums[i-1]) {
                for ( int j = 0 ; j < cnt ; j++ )
                    if (partD[j] == myNums[i]) {
                        x = false;
                        break;
                    }
                if (x){
                    cnt++;
                    partD[cnt-1] = myNums[i];
                }
            }
        }
        for ( int i=0 ; i < n ; i++ )
            for ( int j=0 ; j <= i ; j++ )
                partC[i] += myNums[j];
        for (int i : myNums) {
            System.out.print( i + "\t" );
        }
        System.out.println("\nA: ");
        System.out.println("max= " + max + "  min= " + min);
        System.out.println("B: ");
        System.out.println("The number of evens: " + even + " odds: " + odd);
        System.out.println("C: ");
        for (int i : partC) {
            System.out.print( i + "\t" );
        }
        System.out.println("\nD:");
        for ( int i=0 ; i < cnt ; i++ ) {
            System.out.print( partD[i] + "\t" );
        }
    }
}
