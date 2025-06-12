package ap.trainingCodes.Potential;

import java.util.Scanner;
public class Potential {
    public static void main(String[] args) {
        final float G = 9.8066f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the mass: ");
        float m = scanner.nextFloat();
        System.out.println("enter the height: ");
        float h = scanner.nextFloat();
        scanner.close();
        System.out.println("potential= mgh= "+(m*G*h));
    }
}
