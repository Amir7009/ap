package ap.exercises.ex1.Ch6.E.E6_1.a;

public class A {
    public static void main(String[] args) {
        int sum=0;
        for (int i=2 ; i <= 100 ; i+=2 )
            sum += i;
        System.out.println( "sum= " + sum );
    }
}
