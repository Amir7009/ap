package ap.exercises.Ch6.E.E6_5;

import java.util.Scanner;

public class E6_5 {
    public static void main(String[] args) {
        System.out.println("Enter the number of inputs: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Enter the floating point numbers: ");
        double x = input.nextDouble();
        double min, max, range, avg;
        min = max = avg = x;
        for (int i=1 ; i < n ; i++ ){
            x = input.nextDouble();
            avg += x;
            max = getLargest( max, x );
            min = getSmallest( min, x );
        }
        range = getRange(max, min);
        avg = getAverage(avg, n);
        System.out.println("largest= " + max);
        System.out.println("smallest= " + min);
        System.out.println("range is= " + range);
        System.out.println("average is= " + avg);
    }

    public static double getAverage (double avg, int n) {
        return avg/n;
    }

    public static double getSmallest (double min, double x) {
        if (x < min)
            min = x;
        return min;
    }

    public static double getLargest (double max, double x) {
        if (x > max)
            max = x;
        return max;
    }

    public static double getRange (double max, double min) {
        return max-min;
    }
}
