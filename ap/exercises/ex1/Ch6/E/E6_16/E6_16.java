package ap.exercises.ex1.Ch6.E.E6_16;

public class E6_16 {
    public static void main(String[] args) {
        for ( int i=1 ; i <= 10 ; i++ ) {
            for (int j = 1; j <= 10; j++)
                System.out.print(i * j + "\t");
            System.out.print("\n");
        }
    }
}
